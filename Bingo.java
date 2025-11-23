public class Bingo extends Jogo{
    
    private TelaBingo bingo;
    private TutorialBingo tutorialBingo;


    public void iniciar(){
        this.bingo = new TelaBingo(this);
        this.bingo.setVisible(true);
    }

    public void iniciarTutorial(){

        this.tutorialBingo = new TutorialBingo(this);
        this.tutorialBingo.setVisible(true);

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
