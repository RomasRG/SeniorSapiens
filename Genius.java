import java.util.ArrayList;
import java.awt.*;
import java.util.Random;
import javax.swing.Timer;

public class Genius extends Jogo{

    private ArrayList<TipoCor> sequencia;
    private int indiceSequencia;
    private Random random;
    private TipoCor[] todasAsCores = TipoCor.values();

    private TelaGenius telaGenius;
    private BancoDeDados bancoDeDados = new BancoDeDados();
    private TutorialGenius tutorialGenius;
    
    public enum TipoCor{

        Verde(new Color(0, 150, 0), new Color(0, 255, 0)),
        Vermelho(new Color(150, 0, 0), new Color(255, 0, 0)),
        Amarelo(new Color(150, 150, 0), new Color(255, 255, 0)),
        Azul(new Color(0, 0, 150), new Color(0, 0, 255));

        final Color corBase;
        final Color corDestaque;

        TipoCor(Color corBase, Color corDestaque){

            this.corBase = corBase;
            this.corDestaque = corDestaque;
        }

    }

    //==========================================================

    public void iniciar(){

        this.sequencia = new ArrayList<>();
        this.indiceSequencia = 0;
        this.random = new Random();

        this.telaGenius = new TelaGenius(this);
        this.telaGenius.setVisible(true);

        proximoTurno();

    }

    //==========================================================

    public void finalizar(){

        bancoDeDados.salvarPartidaGenius(jogador.getID(), pontuacaoFinal);

        if(telaGenius != null){

            telaGenius.dispose();

        }

        if(mainApp != null){

            mainApp.exibirMenuPrincipal();

        }


    }

    //==========================================================

    public void iniciarTutorial(){

        this.tutorialGenius = new TutorialGenius(this);
        this.tutorialGenius.setVisible(true);

    }

    //==========================================================

    public void proximoTurno(){

        int numeroDeCores = todasAsCores.length;

        int indiceAleatorio = random.nextInt(numeroDeCores);

        TipoCor corAleatoria = todasAsCores[indiceAleatorio];

        sequencia.add(corAleatoria);

        indiceSequencia = 0;

        telaGenius.mostrarSequencia(sequencia);

    }

    //==========================================================

    public void compararClique(TipoCor corClicada){

        if(corClicada == sequencia.get(indiceSequencia)){

            GerenciadorDeSom.tocarAcerto();
            indiceSequencia++;
            if(indiceSequencia == sequencia.size()){

                pontuacaoFinal++;
                proximoTurno();

            }

        }
        else {
            
            GerenciadorDeSom.tocarErro();
            telaGenius.gameOver(this.pontuacaoFinal);

        }

    }

    //==========================================================

    public void recomecarJogo(){

        sequencia.clear();
        indiceSequencia = 0;
        pontuacaoFinal = 0;

        Timer delayNovoJogo = new Timer(1000, e -> proximoTurno());
        delayNovoJogo.setRepeats(false);
        delayNovoJogo.start();

    }
    
    //==========================================================

    public void getRanking(){
    
        bancoDeDados.buscarTop10Genius();

    }
}


