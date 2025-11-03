import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    private JFrame menuPrincipal;
    private boolean logado = true;
    private Font fonteDosBotoes = new Font("Arial", Font.BOLD, 24);

    //==========================================================
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> new Main());

    }

    public Main(){

        menuPrincipal = new JFrame("Menu");
        menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuPrincipal.setSize(400, 300);
        menuPrincipal.setLocationRelativeTo(null);
        menuPrincipal.setLayout(new FlowLayout());
        
        

        JButton botaoGenius = new JButton("Genius");
        botaoGenius.setFont(fonteDosBotoes);
        botaoGenius.addActionListener(event -> {
            
            executarJogo(new Genius());

        });
        menuPrincipal.add(botaoGenius);

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