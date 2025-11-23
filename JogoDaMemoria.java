import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class JogoDaMemoria extends Jogo{

    private int movimentos;
    private int movimentosTotais;
    private Random random;
    private int indicePrimeiraCarta = -1;
    private int indiceSegundaCarta = -1;
    private ArrayList<TipoFigura> posicaoCartas;
    private int paresRodada;
    private int paresTotais;

    private TelaJogoDaMemoria telaJogoDaMemoria;
    private BancoDeDados bancoDeDados = new BancoDeDados();
    private TutorialJogoDaMemoria tutorialJogoDaMemoria;

    public enum TipoFigura{

        Coracao("Coracao.png"),
        Estrela("Estrela.png"),
        Lua("Lua.png"),
        Nuvem("Nuvem.png"),
        Raio("Raio.png"),
        Sol("Sol.png"),
        Trevo("Trevo.png"),
        Triangulo("Triangulo.png");

        private String nomeArquivo;

        TipoFigura(String nomeArquivo){

            this.nomeArquivo = nomeArquivo;

        }

        public String getNomeArquivo() {

            return this.nomeArquivo;
        
        }

    } 

    //==========================================================

    public void gerarMesa(){

        ArrayList<TipoFigura> todasAsFiguras = new ArrayList<>();

        // ---- Inicializa o array com todas as figuras do tabuleiro ----
        for(int i = 0; i < 2; i++){

            todasAsFiguras.add(TipoFigura.Coracao);
            todasAsFiguras.add(TipoFigura.Estrela);
            todasAsFiguras.add(TipoFigura.Lua);
            todasAsFiguras.add(TipoFigura.Nuvem);
            todasAsFiguras.add(TipoFigura.Raio);
            todasAsFiguras.add(TipoFigura.Sol);
            todasAsFiguras.add(TipoFigura.Trevo);
            todasAsFiguras.add(TipoFigura.Triangulo);

        }

        ArrayList<TipoFigura> figurasAleatorias = new ArrayList<>();
        TipoFigura figura;
        int indice = 0;

        for(int i = 0; i < 16; i++){

            indice = random.nextInt(16 - i);
            figura = todasAsFiguras.get(indice);
            todasAsFiguras.remove(indice);
            figurasAleatorias.add(figura);

        }

        this.posicaoCartas = figurasAleatorias;

    }

    //==========================================================

    public ArrayList<TipoFigura> getFigurasALeatorias(){

        return posicaoCartas;

    }

    //==========================================================

    public void proximoTurno(){

        this.paresRodada = 0;
        this.paresTotais = 0;
        this.indicePrimeiraCarta = -1;
        this.indiceSegundaCarta = -1;
        gerarMesa();
        telaJogoDaMemoria.resetarTela();
        telaJogoDaMemoria.atualizaPlacar(movimentos, paresTotais);

    }

    //==========================================================

    public void iniciar(){

        this.random = new Random();
        this.telaJogoDaMemoria = new TelaJogoDaMemoria(this);
        this.telaJogoDaMemoria.setVisible(true);

    }

    //==========================================================

    public void finalizar(){

        bancoDeDados.salvarPartidaMemoria(idPessoa, paresTotais, movimentosTotais, pontuacaoFinal);

        if(telaJogoDaMemoria != null){

            telaJogoDaMemoria.dispose();

        }

        if(mainApp != null){

            mainApp.exibirMenuPrincipal();

        }


    }

    //==========================================================

    public void finalizarTutorial(){

        if(tutorialJogoDaMemoria != null){

            tutorialJogoDaMemoria.dispose();

        }

        if(mainApp != null){

            mainApp.exibirMenuPrincipal();

        }

    }

    //==========================================================

    public void iniciarTutorial(){
        
        this.tutorialJogoDaMemoria = new TutorialJogoDaMemoria(this);
        this.tutorialJogoDaMemoria.setVisible(true);

    }

    //==========================================================

    public void recomecarJogo(){

        this.movimentosTotais = 0;
        this.movimentos = 0;
        this.paresRodada = 0;
        this.paresTotais = 0;
        this.indicePrimeiraCarta = -1;
        this.indiceSegundaCarta = -1;
        
        gerarMesa();

        telaJogoDaMemoria.resetarTela();
        telaJogoDaMemoria.atualizaPlacar(this.movimentosTotais, this.paresTotais);

    }

    //==========================================================

    public void compararClique(int indice){

        telaJogoDaMemoria.viraCarta(indice);

        if(indicePrimeiraCarta == -1){

            indicePrimeiraCarta = indice;

        } else {

            indiceSegundaCarta = indice;
            movimentos++;
            movimentosTotais++;
            telaJogoDaMemoria.setBotoesHabilitados(false);

            TipoFigura figura1 = posicaoCartas.get(indicePrimeiraCarta);
            TipoFigura figura2 = posicaoCartas.get(indiceSegundaCarta);

            if(figura1 == figura2){

                GerenciadorDeSom.tocarAcerto();
                paresRodada++;
                paresTotais++;
                pontuacaoFinal += (2/movimentos) * 100;
                movimentos = 0;


                Timer timerDelay1 = new Timer(1000, event ->{
                    telaJogoDaMemoria.removeCarta(indicePrimeiraCarta);
                    telaJogoDaMemoria.removeCarta(indiceSegundaCarta);
                    indicePrimeiraCarta = -1;
                    indiceSegundaCarta = -1;

                    if(paresRodada == 8){

                        telaJogoDaMemoria.mostrarDialogoVitoria();

                    } else {

                        telaJogoDaMemoria.setBotoesHabilitados(true); 

                    }
                });
                timerDelay1.setRepeats(false);
                timerDelay1.start();

            } else {

                GerenciadorDeSom.tocarErro();
                Timer timerDelay2 = new Timer(1000, event -> {
                    telaJogoDaMemoria.viraCostaCartas(indicePrimeiraCarta, indiceSegundaCarta);
                    telaJogoDaMemoria.setBotoesHabilitados(true);
                    indicePrimeiraCarta = -1;
                    indiceSegundaCarta = -1;             
                });

                timerDelay2.setRepeats(false);
                timerDelay2.start();

            }

            telaJogoDaMemoria.atualizaPlacar(movimentosTotais, paresRodada);
        }

    }

    //==========================================================

    public void getRanking() {
        
        bancoDeDados.buscarTop10Memoria();

    }

}