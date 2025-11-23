import javax.swing.*;
import java.awt.*;

public class TutorialJogoDaMemoria extends JFrame{
 
    private Font fonteTitulo = new Font("Arial", Font.BOLD, 30);
    private Font fonteTexto = new Font("Arial", Font.PLAIN, 20);
    private Font fonteBotao = new Font("Arial", Font.BOLD, 24);

    public TutorialJogoDaMemoria(JogoDaMemoria logicaJogoDaMemoria){

        super("Como jogar Jogo Da Memória");

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(20, 20));

        //  Título
        JLabel labelTitulo = new JLabel("Como jogar Jogo Da Memória", JLabel.CENTER);
        labelTitulo.setFont(fonteTitulo);
        labelTitulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(labelTitulo, BorderLayout.NORTH);

        //  Painel Central
        JPanel painelCentro = new JPanel();
        painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
        painelCentro.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        //  Área de Texto
        String textoInstrucoes = 
            "Jogo da memória é um jogo em que você precisa encontrar os pares de figuras. \n" +
            "Todas as figuras começaram inicialmente viradas para cima e então serão viradas para baixo.\n" +
            "Clique com o botão esquerdo em cima de uma figura e em seguida, em cima da outra figura igual a esta. \n" +
            "Prossiga encontrando os pares até finalizar o tabuleiro. \n\n" +
            "Bom jogo!";

        JTextArea areaTexto = new JTextArea(textoInstrucoes);
        areaTexto.setFont(fonteTexto);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setEditable(false);
        areaTexto.setOpaque(false);      
        areaTexto.setBackground(new Color(0,0,0,0));

        painelCentro.add(areaTexto);
        add(painelCentro, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new FlowLayout());
        painelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));

        //  Botão de Jogo
        JButton botaoJogar = new JButton("ENTENDI, VAMOS JOGAR!");
        botaoJogar.setFont(fonteBotao);
        botaoJogar.setBackground(new Color(34, 139, 34));
        botaoJogar.setForeground(Color.WHITE);

        botaoJogar.addActionListener(event -> {
            GerenciadorDeSom.tocarClique();
            dispose();
            logicaJogoDaMemoria.iniciar();
        });

        painelInferior.add(botaoJogar);
        add(painelInferior, BorderLayout.SOUTH);
    }
}
