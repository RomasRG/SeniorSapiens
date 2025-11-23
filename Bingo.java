public class Bingo extends Jogo{
    
    private TelaBingo telaBingo;
    private TutorialBingo tutorialBingo;


    //==========================================================

    public void iniciar(){
        this.telaBingo = new TelaBingo(this);
        this.telaBingo.setVisible(true);
    }

    //==========================================================

    public void iniciarTutorial(){

        this.tutorialBingo = new TutorialBingo(this);
        this.tutorialBingo.setVisible(true);

    }

    //==========================================================

    public void finalizar(){
        if(telaBingo != null){

            telaBingo.dispose();

        }
        if(mainApp != null){

            mainApp.exibirMenuPrincipal();

        }

        
    }

    //==========================================================

    public void finalizarTutorial(){

        if(tutorialBingo != null){

            tutorialBingo.dispose();

        }

        if(mainApp != null){

            mainApp.exibirMenuPrincipal();

        }

    }

    
    
}
