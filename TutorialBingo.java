import javax.swing.*;
import java.awt.*;

public class TutorialBingo extends JFrame{
    
    private Font fonteTitulo = new Font("Arial", Font.BOLD, 30);
    private Font fonteTexto = new Font("Arial", Font.PLAIN, 20);
    private Font fonteBotao = new Font("Arial", Font.BOLD, 24);

    public TutorialBingo(Bingo logicaBingo){

        super("Como jogar Bingo");

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(20, 20));
        setResizable(false);
        
        addWindowListener(new java.awt.event.WindowAdapter() {

        public void windowClosing(java.awt.event.WindowEvent windowEvent) {

            GerenciadorDeSom.tocarClique();
            logicaBingo.finalizarTutorial();

        }});

        //  Título
        JLabel labelTitulo = new JLabel("Como jogar Bingo", JLabel.CENTER);
        labelTitulo.setFont(fonteTitulo);
        labelTitulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(labelTitulo, BorderLayout.NORTH);

        //  Painel Central
        JPanel painelCentro = new JPanel();
        painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
        painelCentro.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        //  Área de Texto
        String textoInstrucoes = 
            "Preencha a cartela conforme as peças forem sorteadas. \n\n" +
            "Aperte botão esquerdo do mouse em cima do número quando ele for sorteado.\n\n" +
            "Se tiver apertado no número errado, aperte novamente em cima do número para desmarcá-lo. \n\n" +
            "Boa sorte!";

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
            logicaBingo.iniciar();
        });

        painelInferior.add(botaoJogar);
        add(painelInferior, BorderLayout.SOUTH);
    }

}
