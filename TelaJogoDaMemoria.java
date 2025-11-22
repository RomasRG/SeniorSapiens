import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import java.awt.*;
import java.util.Map;
import java.util.HashMap;
import java.net.URL;

public class TelaJogoDaMemoria extends JFrame{

    private JogoDaMemoria logicaJogoDaMemoria;

    private ArrayList<JogoDaMemoria.TipoFigura> posicaoFinal = new ArrayList<>();
    private ImageIcon iconeCostas;
    private String pastaDasImagens = "/Imagens/";
    private Map<JogoDaMemoria.TipoFigura, ImageIcon> iconesFiguras = new HashMap<>();
    private ArrayList<JButton> botoes = new ArrayList<>();
    private Font fontePadrao = new Font("Arial", Font.BOLD, 24);

    private JPanel painelJogo = new JPanel(new GridLayout(4, 4));
    private JPanel painelTopo = new JPanel(new BorderLayout());
    private JPanel painelInferior = new JPanel(new GridLayout(1,2));

    private JLabel labelMovimentos = new JLabel("Movimentos: 0");
    private JLabel labelParesEncontrados = new JLabel("Pares Completos: 0");

    //==========================================================
    
    public TelaJogoDaMemoria(JogoDaMemoria logicaJogoDaMemoria){

        super("Jogo da Memória");
        this.logicaJogoDaMemoria = logicaJogoDaMemoria;

        // ---- Configuração Janela ----

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ---- Figuras ----

        URL urlCostas = getClass().getResource(pastaDasImagens + "Costas.png"); // (ou o nome do seu arquivo)
        if(urlCostas == null) { throw new RuntimeException("Não foi possível encontrar a imagem: Costas.png"); }
        iconeCostas = new ImageIcon(urlCostas);

        for(JogoDaMemoria.TipoFigura figura : JogoDaMemoria.TipoFigura.values()){

            URL urlFigura = getClass().getResource(pastaDasImagens + figura.getNomeArquivo());

            if(urlFigura == null){

                throw new RuntimeException("Não foi possivel encontrar a imagem: "+ pastaDasImagens +figura.getNomeArquivo());

            }

            iconesFiguras.put(figura, new ImageIcon(urlFigura));
            
        }
        logicaJogoDaMemoria.gerarMesa();
        posicaoFinal = logicaJogoDaMemoria.getFigurasALeatorias();

        // ---- Botões ----
        for(int i = 0; i < 16; i++){

            botoes.add(new JButton());
            botoes.get(i).setIcon(iconesFiguras.get(posicaoFinal.get(i)));
            botoes.get(i).setDisabledIcon(iconesFiguras.get(posicaoFinal.get(i)));
            painelJogo.add(botoes.get(i));
            botoes.get(i).setActionCommand(Integer.toString(i));

            botoes.get(i).addActionListener(event -> {

                String indiceString = event.getActionCommand();
                int indice = Integer.parseInt(indiceString);
                logicaJogoDaMemoria.compararClique(indice);

            });

        }

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
            telaRanking();
        });
        painelInferior.add(botaoRanking);
        painelInferior.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // ---- Painel de Pontos ----
        labelMovimentos.setFont(fontePadrao);
        labelParesEncontrados.setFont(fontePadrao);
        painelTopo.add(labelParesEncontrados, BorderLayout.WEST);
        painelTopo.add(labelMovimentos, BorderLayout.EAST);
        painelTopo.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // ---- Montagem da Tela ----
        add(painelTopo, BorderLayout.NORTH);
        add(painelJogo, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        Timer timerInicio = new Timer(5000, event -> {
            escondeCartas();
        });
        timerInicio.setRepeats(false);
        timerInicio.start();
        setBotoesHabilitados(false);

        // ---- Sair ----
        addWindowListener(new java.awt.event.WindowAdapter() {

        public void windowClosing(java.awt.event.WindowEvent windowEvent) {

            logicaJogoDaMemoria.finalizar();

        }});

    }

    //==========================================================

    private void recomecarJogo(){

        logicaJogoDaMemoria.recomecarJogo();

    }

    //==========================================================

    public void setBotoesHabilitados(boolean estado){

        for(int i = 0; i < 16; i++){

            if(botoes.get(i).isContentAreaFilled()){

                botoes.get(i).setEnabled(estado);

            }

        }

    }

    //==========================================================

    public void removeCarta(int indice){

        JButton botao = botoes.get(indice);

        botao.setEnabled(false);
        botao.setIcon(null);
        botao.setDisabledIcon(null);
        botao.setBorderPainted(false);
        botao.setContentAreaFilled(false);

    }

    //==========================================================

    public void viraCarta(int indice){

        botoes.get(indice).setIcon(iconesFiguras.get(posicaoFinal.get(indice)));
        botoes.get(indice).setDisabledIcon(iconesFiguras.get(posicaoFinal.get(indice)));
        botoes.get(indice).setEnabled(false);

    }

    //==========================================================
    
    public void viraCostaCartas(int indice1, int indice2){

        botoes.get(indice1).setIcon(iconeCostas);
        botoes.get(indice1).setDisabledIcon(iconeCostas);

        botoes.get(indice2).setIcon(iconeCostas);
        botoes.get(indice2).setDisabledIcon(iconeCostas);

    }

    //==========================================================

    public void escondeCartas(){

        for(int i = 0; i < 16; i++){

            botoes.get(i).setIcon(iconeCostas);
            botoes.get(i).setDisabledIcon(iconeCostas);

        }

        setBotoesHabilitados(true);

    }

    //==========================================================

    public void atualizaPlacar(int movimentos, int paresTotais){

        this.labelMovimentos.setText("Movimentos: " + movimentos);
        this.labelParesEncontrados.setText("Pares Completos: " + paresTotais);

    }

    //==========================================================

    public void resetarTela(){

        this.posicaoFinal = logicaJogoDaMemoria.getFigurasALeatorias();
        for (int i = 0; i < botoes.size(); i++) {

            JButton botao = botoes.get(i);
            botao.setIcon(iconesFiguras.get(posicaoFinal.get(i)));
            botao.setDisabledIcon(iconesFiguras.get(posicaoFinal.get(i)));
            botao.setBorderPainted(true);
            botao.setContentAreaFilled(true);
            botao.setEnabled(true);

        }

        Timer timerInicio = new Timer(5000, event -> {
            escondeCartas();
        });
        timerInicio.setRepeats(false);
        timerInicio.start();
        setBotoesHabilitados(false);

    }

    //==========================================================

    public void mostrarDialogoVitoria(){

        Object[] opcoes = {"Continuar (Próxima Rodada)", "Sair e Salvar"};

        String textoFormatado = 
            "<html>" +
            "<div style='text-align: center;'>" +
            "Você completou uma rodada!" + "<br>" +
            "Deseja Continuar?" +
            "</div>" +
            "</html>";

        JLabel mensagem = new JLabel(textoFormatado);

        mensagem.setFont(fontePadrao);

        int resultado = JOptionPane.showOptionDialog(
            this,
            mensagem,
            "Vitória!",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcoes,
            opcoes[0]
        );

        if (resultado == 0){
            logicaJogoDaMemoria.proximoTurno();
        }

        else {
            logicaJogoDaMemoria.finalizar();
        }

    }

    public void telaRanking(){

        List<RegistroRankingMemoria> top10 =logicaJogoDaMemoria.getRanking();


    }

}
