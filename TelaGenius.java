import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.HashMap;

public class TelaGenius extends JFrame{

    private JButton botaoVermelho, botaoVerde, botaoAzul, botaoAmarelo;
    private Map<Genius.TipoCor, JButton> botoesMap = new HashMap<>();
    private ArrayList<Genius.TipoCor> sequenciaAtual = new ArrayList<>();
    private int indiceSequenciaAtual;
    private Timer timerSequencia;
    private boolean piscando;

    public TelaGenius(Genius logicaGenius){

        super("Genius");

        // ---- Configuração Janela ----

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        // ---- Timer ----

        timerSequencia = new Timer(400, e -> executarPassoDaSequencia());
        timerSequencia.setRepeats(true);

        // ---- Botão Vermelho ----
        botaoVermelho = new JButton("Vermelho");
        botaoVermelho.setBackground(Color.RED);
        botoesMap.put(Genius.TipoCor.Vermelho, botaoVermelho);

        botaoVermelho.addActionListener(event -> {
            piscarBotao(Genius.TipoCor.Vermelho);
            logicaGenius.compararClique(Genius.TipoCor.Vermelho);
        });

        add(botaoVermelho);

        // ---- Botão Azul ----
        botaoAzul = new JButton("Azul");
        botaoAzul.setBackground(Color.BLUE);
        botoesMap.put(Genius.TipoCor.Azul, botaoAzul);

        botaoAzul.addActionListener(event -> {
            piscarBotao(Genius.TipoCor.Azul);
            logicaGenius.compararClique(Genius.TipoCor.Azul);
        });

        add(botaoAzul);

        // ---- Botão Amarelo ----
        botaoAmarelo = new JButton("Amarelo");
        botaoAmarelo.setBackground(Color.YELLOW);
        botoesMap.put(Genius.TipoCor.Amarelo, botaoAmarelo);

        botaoAmarelo.addActionListener(event -> {
            piscarBotao(Genius.TipoCor.Amarelo);
            logicaGenius.compararClique(Genius.TipoCor.Amarelo);
        });

        add(botaoAmarelo);

        // ---- Botão Verde ----
        botaoVerde = new JButton("Verde");
        botaoVerde.setBackground(Color.GREEN);
        botoesMap.put(Genius.TipoCor.Verde, botaoVerde);

        botaoVerde.addActionListener(event -> {
            piscarBotao(Genius.TipoCor.Verde);
            logicaGenius.compararClique(Genius.TipoCor.Verde);
        });

        add(botaoVerde);

    }

    public void mostrarSequencia(ArrayList<Genius.TipoCor> sequencia){

        setBotoesHabilitados(false);
        this.sequenciaAtual = sequencia;
        this.indiceSequenciaAtual = 0;
        this.piscando = true;
        timerSequencia.start();

    }

    public void gameOver(int pontuacaoFinal){

        JOptionPane.showMessageDialog(
            this, 
            "Você errou! Sua pontuação final foi: " + pontuacaoFinal,
            "Game Over",
            1
        );
        setBotoesHabilitados(false);

    }

    public void piscarBotao(Genius.TipoCor cor){

        JButton botao = botoesMap.get(cor);

        botao.setBackground(cor.corDestaque);

        Timer timerPiscada = new Timer(250, event ->{
            botao.setBackground(cor.corBase);
        });

        timerPiscada.setRepeats(false);
        timerPiscada.start();

    }

    private void setBotoesHabilitados(boolean habilitado){

        for(JButton botao : botoesMap.values()){

            botao.setEnabled(habilitado);

        }

    }

    private void executarPassoDaSequencia(){

        if(indiceSequenciaAtual >= sequenciaAtual.size()){

            timerSequencia.stop();
            setBotoesHabilitados(true);
            return;
            
        }

        Genius.TipoCor cor = sequenciaAtual.get(indiceSequenciaAtual);
        JButton botao = botoesMap.get(cor);

        if(piscando){

            botao.setBackground(cor.corDestaque);
            piscando = false;

        }else{

            botao.setBackground(cor.corBase);
            piscando = true;
            indiceSequenciaAtual++;

        }

    }
    
}
