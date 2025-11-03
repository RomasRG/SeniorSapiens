import java.util.ArrayList;
import java.awt.*;

public class Genius extends Jogo{

    private ArrayList<TipoCor> sequencia;
    private int indiceSequencia;

    private TelaGenius telaGenius;
    
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

        this.telaGenius = new TelaGenius(this);
        this.telaGenius.setVisible(true);

    }

    //==========================================================

    public void finalizar(){

        //Salvar pontuação no BD

        if(telaGenius != null){

            telaGenius.dispose();

        }

        if(mainApp != null){

            mainApp.exibirMenuPrincipal();

        }


    }

    //==========================================================

    public void proximoTurno(){

        

    }

    //==========================================================

    public void compararClique(TipoCor corClicada){

        if(corClicada == sequencia.get(indiceSequencia)){

            indiceSequencia++;
            if(indiceSequencia == sequencia.size()){

                proximoTurno();

            }

        }
        else {
            
            pontuacaoFinal = sequencia.size() - 1;
            telaGenius.gameOver(this.pontuacaoFinal);

        }

    }

    //==========================================================
    
}


