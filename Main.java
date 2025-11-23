import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    private JFrame menuPrincipal;
    private Font fontePadrao = new Font("Arial", Font.BOLD, 24);
    private boolean admin = false;
    private int idGerado;

    //==========================================================
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> new TelaCadastroPessoa());

    }

    public Main(int idGerado, boolean admin){

        this.idGerado = idGerado;
        this.admin = admin;
        menuPrincipal = new JFrame("Menu");
        menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuPrincipal.setSize(400, 300);
        menuPrincipal.setLocationRelativeTo(null);
        menuPrincipal.setLayout(new FlowLayout());

        JButton botaoGenius = new JButton("Genius");
        botaoGenius.setFont(fontePadrao);
        botaoGenius.addActionListener(event -> {
            
            GerenciadorDeSom.tocarClique();
            executarJogo(new Genius());

        });
        menuPrincipal.add(botaoGenius);

        JButton botaoBingo = new JButton("Bingo");
        botaoBingo.setFont(fontePadrao);
        botaoBingo.addActionListener(event -> {
            
            GerenciadorDeSom.tocarClique();
            executarJogo(new Bingo());

        });
        menuPrincipal.add(botaoBingo);

        JButton botaoJogoDaMemoria = new JButton("Jogo da Memória");
        botaoJogoDaMemoria.setFont(fontePadrao);
        botaoJogoDaMemoria.addActionListener(event -> {
            
            GerenciadorDeSom.tocarClique();
            executarJogo(new JogoDaMemoria());

        });
        menuPrincipal.add(botaoJogoDaMemoria);

        menuPrincipal.setVisible(true);

    }

    //==========================================================

    public void exibirMenuPrincipal(){

        menuPrincipal.setVisible(true);

    }

    //==========================================================

    public void executarJogo(Jogo jogoEscolhido){

        menuPrincipal.setVisible(false);
        jogoEscolhido.setMainApp(this);
        jogoEscolhido.idPessoa = idGerado;
        jogoEscolhido.iniciarTutorial();


    }

    //==========================================================

}