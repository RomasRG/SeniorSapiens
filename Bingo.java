public class Bingo extends Jogo{
    private TelaBingo bingo;


    public void iniciar(){
        this.bingo = new TelaBingo(this);
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
