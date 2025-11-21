public class Bingo extends Jogo{
    private BingoUI bingo;


    public void iniciar(){
        this.bingo = new BingoUI(this);
        this.bingo.setVisible(true);
    }

    public void finalizar(){
        if(bingo != null){

            bingo.dispose();

        }
        if(mainApp != null){

            mainApp.exibirMenuPrincipal();

        }

        
    }
    
}
