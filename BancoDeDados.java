import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class BancoDeDados {

    //Escolhe usar uma impressão na tela ao invés do banco real por fins de exemplo
    private boolean usarBancoReal = false;

    private static final String URL = "jdbc:mysql://localhost:3306/nome_do_seu_banco";
    private static final String USER = "root";
    private static final String PASSWORD = "sua_senha_aqui";

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
            JOptionPane.showMessageDialog(
            null,
            "SIMULAÇÃO DE BANCO DE DADOS:\n\n" +
            "Dados enviados para persistência:\n" +
            "ID Jogador: " + pessoaId + "\n" +
            "Pares: " + pares + "\n" +
            "Movimentos: " + movimentos + "\n" +
            "Pontuação Final: " + pontuacao + "\n\n" +
            "Status: GRAVADO COM SUCESSO!",
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
            JOptionPane.showMessageDialog(
            null,
            "SIMULAÇÃO DE BANCO DE DADOS:\n\n" +
            "Dados enviados para persistência:\n" +
            "ID Jogador: " + pessoaId + "\n" +
            "Sequencia: " + sequencia + 
            "Status: GRAVADO COM SUCESSO!",
            "Banco De Dados",
            JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    
}
