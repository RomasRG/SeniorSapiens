import javax.swing.*;

public class Main extends JFrame{

    private static JFrame menuPrincipal;
    private static boolean logado = true;
    private static JButton botaoGenius;

    //==========================================================
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> new Main());

    }

    public Main(){

        botaoGenius = new JButton("botaoGenius");
        botaoGenius.addActionListener(event -> {
            
            executarJogo(new Genius());

        });

        menuPrincipal.setVisible(true);

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
        else{

            JOptionPane.showMessageDialog(

                null,
                "Insira um nome ou logue antes te começar.",
                "Erro ao Iniciar",
                1

            );

        }

    }

    //==========================================================

    public void exibirRanking(){



    }

    //==========================================================

    public void cadastroAdmin(){



    }

    //==========================================================

    public static void loginAdmin(String email, String senha){

        

    }

}