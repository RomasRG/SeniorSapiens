import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaRankingGenius extends JFrame{

        private Font fontePadrao = new Font("Arial", Font.BOLD, 24);

    public TelaRankingGenius(List<RegistroRankingGenius> lista) {
            super("Ranking - Genius");
            
            // Configurações da Janela
            setSize(500, 400);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Cria a tabela
            String[] colunas = {"Posição", "Nome", "Idade", "Sequencia de Cores"};
            DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

            // Preenche com os dados retornados
            for (int i = 0; i < lista.size(); i++) {
                RegistroRankingGenius r = lista.get(i);
                Object[] linha = {
                    (i + 1) + "º",
                    r.getNome(),
                    r.getIdade(),
                    r.getPontuacao()
                };
                modelo.addRow(linha);
            }

            // 4. Mostra na tela
            JTable tabela = new JTable(modelo);

            tabela.setFont(fontePadrao);
            tabela.setRowHeight(40);
            tabela.getTableHeader().setFont(fontePadrao);

            add(new JScrollPane(tabela), BorderLayout.CENTER);
    }
}

