import java.util.ArrayList;
import javax.swing.*;

import java.awt.*;
import java.util.Map;
import java.util.HashMap;

public class TelaGenius extends JFrame{

    private Genius logicaGenius;

    private JButton botaoVermelho, botaoVerde, botaoAzul, botaoAmarelo;
    private Map<Genius.TipoCor, JButton> botoesMap = new HashMap<>();
    private ArrayList<Genius.TipoCor> sequenciaAtual = new ArrayList<>();
    private int indiceSequenciaAtual;
    private Timer timerSequencia;
    private boolean piscando;
    private Font fontePadrao = new Font("Arial", Font.BOLD, 24);

    private JPanel painelJogo = new JPanel(new GridLayout(2, 2));
    private JPanel painelInferior = new JPanel(new GridLayout(1,2));
    private JPanel painelPontos = new JPanel(new BorderLayout());
    private JLabel labelParesEncontrados = new JLabel("Sequencia: 0");

    public TelaGenius(Genius logicaGenius){

        super("Genius");
        this.logicaGenius = logicaGenius;

        // ---- Configuração Janela ----

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ---- Timer ----

        timerSequencia = new Timer(750, e -> executarPassoDaSequencia());
        timerSequencia.setRepeats(true);

        // ---- Botão Vermelho ----
        botaoVermelho = new JButton("Vermelho");
        botaoVermelho.setFont(fontePadrao);
        botaoVermelho.setBackground(Genius.TipoCor.Vermelho.corBase);
        botoesMap.put(Genius.TipoCor.Vermelho, botaoVermelho);

        botaoVermelho.addActionListener(event -> {
            piscarBotao(Genius.TipoCor.Vermelho);
            logicaGenius.compararClique(Genius.TipoCor.Vermelho);
        });

        painelJogo.add(botaoVermelho);

        // ---- Botão Azul ----
        botaoAzul = new JButton("Azul");
        botaoAzul.setFont(fontePadrao);
        botaoAzul.setBackground(Genius.TipoCor.Azul.corBase);
        botoesMap.put(Genius.TipoCor.Azul, botaoAzul);

        botaoAzul.addActionListener(event -> {
            piscarBotao(Genius.TipoCor.Azul);
            logicaGenius.compararClique(Genius.TipoCor.Azul);
        });

        painelJogo.add(botaoAzul);

        // ---- Botão Amarelo ----
        botaoAmarelo = new JButton("Amarelo");
        botaoAmarelo.setFont(fontePadrao);
        botaoAmarelo.setBackground(Genius.TipoCor.Amarelo.corBase);
        botoesMap.put(Genius.TipoCor.Amarelo, botaoAmarelo);

        botaoAmarelo.addActionListener(event -> {
            piscarBotao(Genius.TipoCor.Amarelo);
            logicaGenius.compararClique(Genius.TipoCor.Amarelo);
        });

        painelJogo.add(botaoAmarelo);

        // ---- Botão Verde ----
        botaoVerde = new JButton("Verde");
        botaoVerde.setFont(fontePadrao);
        botaoVerde.setBackground(Genius.TipoCor.Verde.corBase);
        botoesMap.put(Genius.TipoCor.Verde, botaoVerde);

        botaoVerde.addActionListener(event -> {
            piscarBotao(Genius.TipoCor.Verde);
            logicaGenius.compararClique(Genius.TipoCor.Verde);
        });

        painelJogo.add(botaoVerde);

        // ---- Desabilita os Botões ----
        setBotoesHabilitados(false);

        // ---- Botão Reset ----
        JButton botaoRecomecar = new JButton("Recomeçar");
        botaoRecomecar.setFont(fontePadrao);
        botaoRecomecar.addActionListener(event -> {
            recomecarJogo();
        });
        
        painelInferior.add(botaoRecomecar);

        JButton botaoRanking = new JButton("Ranking");
        botaoRanking.setFont(fontePadrao);
        botaoRanking.addActionListener(event -> {
            logicaGenius.getRanking();
        });
        painelInferior.add(botaoRanking);

        painelInferior.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        

        // ---- Painel de Pontos ----
        labelParesEncontrados.setFont(fontePadrao);
        painelPontos.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        painelPontos.add(labelParesEncontrados, BorderLayout.WEST);

        // ---- Montagem da Tela ----
        add(painelPontos, BorderLayout.NORTH);
        add(painelJogo, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        // ---- Sair ----
        addWindowListener(new java.awt.event.WindowAdapter() {

        public void windowClosing(java.awt.event.WindowEvent windowEvent) {

            logicaGenius.finalizar();

        }});

    }

    public void mostrarSequencia(ArrayList<Genius.TipoCor> sequencia){

        setBotoesHabilitados(false);
        this.sequenciaAtual = sequencia;
        this.indiceSequenciaAtual = 0;
        this.piscando = true;
        this.labelParesEncontrados.setText("Pontos: " + (sequencia.size() - 1));
        timerSequencia.start();

    }

    public void gameOver(int pontuacaoFinal){

        String textoFormatado = 
            "<html>" +
            "<div style='text-align: center;'>" +
            "Você errou! Sua pontuação final foi: " + pontuacaoFinal + "<br>" +
            "Acabou o jogo!" +
            "</div>" +
            "</html>";

        JLabel mensagem = new JLabel(textoFormatado);

        mensagem.setFont(fontePadrao);

        JOptionPane.showMessageDialog(
            this, 
            mensagem,
            "Errou a sequência!",
            1
        );
        setBotoesHabilitados(false);

    }

    public void piscarBotao(Genius.TipoCor cor){

        JButton botao = botoesMap.get(cor);

        botao.setBackground(cor.corDestaque);

        Timer timerPiscada = new Timer(375, event ->{
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

    private void recomecarJogo(){

        botaoVermelho.setBackground(Genius.TipoCor.Vermelho.corBase);
        botaoAzul.setBackground(Genius.TipoCor.Azul.corBase);
        botaoAmarelo.setBackground(Genius.TipoCor.Amarelo.corBase);
        botaoVerde.setBackground(Genius.TipoCor.Verde.corBase);

        logicaGenius.recomecarJogo();

    }
    
}
