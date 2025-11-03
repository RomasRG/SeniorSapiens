import javax.swing.*;

public class Main extends JFrame{

    private JFrame menuPrincipal;
    private boolean logado = false;

    //==========================================================
    public static void main(String[] args) {
        
    }

    //==========================================================

    public void exibirMenuPrincipal(){

        menuPrincipal.setVisible(true);

    }

    //==========================================================

    public void iniciarSessaoUsuario(){



    }

    //==========================================================

    public void executarJogo(Jogo jogoEscolhido){

        if(logado){

            menuPrincipal.setVisible(false);
            jogoEscolhido.setMainApp(this);
            jogoEscolhido.iniciar();

        }

    }

    //==========================================================

    public void exibirRanking(){



    }

    //==========================================================

    public void cadastroAdmin(){



    }

    //==========================================================

    public void loginAdmin(String email, String senha){

        

    }

}