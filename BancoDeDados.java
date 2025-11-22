import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.*;

public class BancoDeDados {

    //Escolhe usar uma impressão na tela ao invés do banco real por fins de exemplo
    private boolean usarBancoReal = false;

    private static final String URL = "jdbc:mysql://localhost:3306/nome_do_seu_banco";
    private static final String USER = "root";
    private static final String PASSWORD = "sua_senha_aqui";

    private Font fontePadrao = new Font("Arial", Font.BOLD, 24);

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    //==========================================================

    public void salvarPartidaMemoria(int pessoaId, int pares, int movimentos, int pontuacao) {
        
        if(usarBancoReal){
            String sql = "INSERT INTO historico_memoria (pessoa_id, pares_encontrados, movimentos, pontuacao) VALUES (?, ?, ?, ?)";

            try (Connection conn = conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, pessoaId);
                stmt.setInt(2, pares);
                stmt.setInt(3, movimentos);
                stmt.setInt(4, pontuacao);

                stmt.executeUpdate();
                System.out.println("Dados salvos com sucesso no Banco de Dados!");

            } catch (SQLException sqlException) {
                System.err.println("Erro ao salvar no banco: " + sqlException.getMessage());
                sqlException.printStackTrace();
            }
        } else {

            String textoFormatado = 
            "<html>" +
            "<div style='text-align: center;'>" +
            "SIMULAÇÃO DE GRAVAÇÃO DE DADOS:<br><br>" +
            "Dados enviados:<br>" +
            "ID Jogador: " + pessoaId + "<br>" +
            "Pares: " + pares  + "<br>" +
            "Movimentos: " + movimentos + "<br>" +
            "Pontuação Final: " + pontuacao + "<br><br>" +
            "Status: GRAVADO COM SUCESSO!" +
            "</div>" +
            "</html>";

            JLabel mensagem = new JLabel(textoFormatado);

            mensagem.setFont(this.fontePadrao);

            JOptionPane.showMessageDialog(
            null,
            mensagem,
            "Banco De Dados",
            JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    //==========================================================

    public void salvarPartidaGenius(int pessoaId, int sequencia){
        
        if(usarBancoReal){
            String sql = "INSERT INTO historico_genius (pessoa_id, sequencia) VALUES (?, ?)";

            try(Connection conn = conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)){

                    stmt.setInt(1, pessoaId);
                    stmt.setInt(2, sequencia);

            } catch(SQLException sqlException) {
                System.err.println("Erro ao salvar no banco: " + sqlException.getMessage());
                sqlException.printStackTrace();
            }
        } else {

            String textoFormatado = 
            "<html>" +
            "<div style='text-align: center;'>" +
            "SIMULAÇÃO DE GRAVAÇÃO DE DADOS:<br><br>" +
            "Dados enviados:<br>" +
            "ID Jogador: " + pessoaId + "<br>" +
            "Sequencia: " + sequencia + "<br><br>" +
            "Status: GRAVADO COM SUCESSO!" +
            "</div>" +
            "</html>";

            JLabel mensagem = new JLabel(textoFormatado);
            
            mensagem.setFont(fontePadrao);

            JOptionPane.showMessageDialog(
            null,
            mensagem,
            "Banco De Dados",
            JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    
    //==========================================================

    public void buscarTop10Genius(){

        List<RegistroRankingGenius> listaRanking = new ArrayList<>();
        
        if(usarBancoReal){
            String sql = "SELECT p.id, p.nome, p.idade, hg.sequencia " +
                 "FROM historico_genius hg " +
                 "INNER JOIN pessoa p ON hg.pessoa_id = p.id " +
                 "ORDER BY hg.sequencia DESC LIMIT 10";

            try (Connection conn = conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    RegistroRankingGenius registro = new RegistroRankingGenius(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getInt("sequencia")
                    );
                    listaRanking.add(registro);
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        } else {
            listaRanking.add(new RegistroRankingGenius(1, "Seu João", 81, 21));
            listaRanking.add(new RegistroRankingGenius(2, "Vovó Juju", 75, 19));
            listaRanking.add(new RegistroRankingGenius(3, "Alberto", 45, 16));
            listaRanking.add(new RegistroRankingGenius(4, "Dona Neide", 69, 15));
            listaRanking.add(new RegistroRankingGenius(5, "Amelie", 53, 12));
            listaRanking.add(new RegistroRankingGenius(6, "Dona Maria", 82, 9));
            listaRanking.add(new RegistroRankingGenius(7, "Ana Maria", 67, 8));
            listaRanking.add(new RegistroRankingGenius(8, "Amara", 78, 7));
            listaRanking.add(new RegistroRankingGenius(9, "Paulo", 64, 6));
            listaRanking.add(new RegistroRankingGenius(10, "Roberto", 57, 4));
        }
        
        TelaRankingGenius telaRankingGenius = new TelaRankingGenius(listaRanking);
        telaRankingGenius.setVisible(true);

    }

    //==========================================================

    public void buscarTop10Memoria() {
        List<RegistroRankingMemoria> listaRanking = new ArrayList<>();
        
        if(usarBancoReal){
            String sql = "SELECT p.id, p.nome, p.idade, hm.pontuacao, hm.pares_encontrados " +
             "FROM historico_Memoria hm " +
             "INNER JOIN pessoa p ON hm.pessoa_id = p.id " +
             "ORDER BY hm.pontuacao DESC LIMIT 10";

            try (Connection conn = conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    RegistroRankingMemoria registro = new RegistroRankingMemoria(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getInt("pontuacao"),
                        rs.getInt("pares_encontrados")
                    );
                    listaRanking.add(registro);
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        } else {
            listaRanking.add(new RegistroRankingMemoria(1, "Seu João", 81, 5000, 60));
            listaRanking.add(new RegistroRankingMemoria(2, "Vovó Juju", 75, 4500, 55));
            listaRanking.add(new RegistroRankingMemoria(3, "Alberto", 45, 4000, 50));
            listaRanking.add(new RegistroRankingMemoria(4, "Dona Neide", 69, 3800, 48));
            listaRanking.add(new RegistroRankingMemoria(5, "Amelie", 53, 3500, 45));
            listaRanking.add(new RegistroRankingMemoria(6, "Dona Maria", 82, 3200, 40));
            listaRanking.add(new RegistroRankingMemoria(7, "Ana Maria", 67, 3000, 38));
            listaRanking.add(new RegistroRankingMemoria(8, "Amara", 78, 2800, 35));
            listaRanking.add(new RegistroRankingMemoria(9, "Paulo", 64, 2500, 30));
            listaRanking.add(new RegistroRankingMemoria(10, "Roberto", 57, 1500, 20));
        }
        
        TelaRankingMemoria telaRankingMemoria = new TelaRankingMemoria(listaRanking);
        telaRankingMemoria.setVisible(true);
    }
}
