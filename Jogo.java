public abstract class Jogo {

    protected Usuario jogador;
    protected int pontuacaoFinal;

    //==========================================================
    
    public abstract void iniciar();

    //==========================================================

    public abstract void jogar();

    //==========================================================

    public abstract void finalizar();

    //==========================================================

    public int getPontuacaoFinal(){

        return pontuacaoFinal;

    }

    
}
