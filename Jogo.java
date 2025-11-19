public abstract class Jogo {

    protected Pessoa jogador;
    protected int pontuacaoFinal;
    protected Main mainApp;

    //==========================================================
    
    public abstract void iniciar();

    //==========================================================

    public abstract void finalizar();

    //==========================================================

    public int getPontuacaoFinal(){

        return pontuacaoFinal;

    }

    public void setMainApp(Main main){

        this.mainApp = main;

    }

    

    
}
