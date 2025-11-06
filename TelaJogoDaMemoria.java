import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.HashMap;

public class TelaJogoDaMemoria extends JFrame{

    private JogoDaMemoria logicaJogoDaMemoria;
    private JButton btF1, btF2, btF3, btF4, btF5, btF6, btF7, btF8;
    private JPanel painelJogo = new JPanel(new GridLayout(4, 4));
    private ImageIcon iconeVirado;
    private Map<TipoFigura, ImageIcon> iconesFiguras;
    
    public TelaJogoDaMemoria(JogoDaMemoria logicaJogoDaMemoria){

        super("Jogo da Memória");
        this.logicaJogoDaMemoria = logicaJogoDaMemoria;

        // ---- Configuração Janela ----

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);



    }

}
