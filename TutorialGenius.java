import javax.swing.*;
import java.awt.*;

public class TutorialGenius extends JFrame{
    
    private Font fonteTitulo = new Font("Arial", Font.BOLD, 30);
    private Font fonteTexto = new Font("Arial", Font.PLAIN, 20);
    private Font fonteBotao = new Font("Arial", Font.BOLD, 24);

    public TutorialGenius(Genius logicaGenius){

        super("Como jogar Genius");

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(20, 20));

        addWindowListener(new java.awt.event.WindowAdapter() {

        public void windowClosing(java.awt.event.WindowEvent windowEvent) {

            GerenciadorDeSom.tocarClique();
            logicaGenius.finalizarTutorial();

        }});

        //  Título
        JLabel labelTitulo = new JLabel("Como jogar Genius", JLabel.CENTER);
        labelTitulo.setFont(fonteTitulo);
        labelTitulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(labelTitulo, BorderLayout.NORTH);

        //  Painel Central
        JPanel painelCentro = new JPanel();
        painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
        painelCentro.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        //  Área de Texto
        String textoInstrucoes = 
            "Genius é um jogo de sequência onde você precisa acertar a sequência de cores. \n\n" +
            "Toda rodada uma cor a mais será acesa, siga a sequência depois dela parar, apertando botão esquerdo em cima da cor.\n\n" +
            "Se perder, ou se apenas quiser recomeçar, aperte o botão esquerdo em cima do 'Recomeçar' no final da tela. \n\n" +
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
            logicaGenius.iniciar();
        });

        painelInferior.add(botaoJogar);
        add(painelInferior, BorderLayout.SOUTH);
    }
}
