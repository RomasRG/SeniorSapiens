import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaRankingMemoria extends JFrame{

    private Font fontePadrao = new Font("Arial", Font.BOLD, 24);

    public TelaRankingMemoria(List<RegistroRankingMemoria> lista) {
            super("Ranking - Jogo da Memória");
            
            // Configurações da Janela
            setSize(500, 400);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Cria a tabela
            String[] colunas = {"Posição", "ID", "Nome", "Idade", "Pontos", "Pares"};
            DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

            // Preenche com os dados
            for (int i = 0; i < lista.size(); i++) {
                RegistroRankingMemoria r = lista.get(i);
                Object[] linha = {
                    (i + 1) + "º",
                    r.getID(),
                    r.getNome(),
                    r.getIdade(),
                    r.getPontuacao(),
                    r.getParesEncontrados()
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
