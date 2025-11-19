import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BancoDeDados {

    private static final String URL = "jdbc:mysql://localhost:3306/nome_do_seu_banco";
    private static final String USER = "root";
    private static final String PASSWORD = "sua_senha_aqui";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    //==========================================================

    public void salvarPartidaMemoria(int pessoaId, int pares, int movimentos, int pontuacao) {
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
    }

    //==========================================================

    public void salvarPartidaGenius(int pessoaID, int sequencia){
        String sql = "INSERT INTO historico_genius (pessoa_id, sequencia) VALUES (?, ?)";

        try(Connection conn = conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

                stmt.setInt(1, pessoaID);
                stmt.setInt(2, sequencia);

        } catch(SQLException sqlException) {
            System.err.println("Erro ao salvar no banco: " + sqlException.getMessage());
            sqlException.printStackTrace();
        }
    }
    
}
