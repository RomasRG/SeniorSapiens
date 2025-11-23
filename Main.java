import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Main extends JFrame{

    private Font fontePadrao = new Font("Arial", Font.BOLD, 24);
    private int idGerado;

    //==========================================================
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> new TelaCadastroPessoa().setVisible(true));

    }

    public Main(int idGerado, boolean admin){

        super("Menu");
        this.idGerado = idGerado;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton botaoGenius = new JButton("Genius");
        botaoGenius.setFont(fontePadrao);
        botaoGenius.addActionListener(event -> {
            
            GerenciadorDeSom.tocarClique();
            executarJogo(new Genius());

        });

        JButton botaoBingo = new JButton("Bingo");
        botaoBingo.setFont(fontePadrao);
        botaoBingo.addActionListener(event -> {
            
            GerenciadorDeSom.tocarClique();
            executarJogo(new Bingo());

        });

        JButton botaoJogoDaMemoria = new JButton("Jogo da Memória");
        botaoJogoDaMemoria.setFont(fontePadrao);
        botaoJogoDaMemoria.addActionListener(event -> {
            
            GerenciadorDeSom.tocarClique();
            executarJogo(new JogoDaMemoria());

        });

        JLabel moldeQuadrado1 = new JLabel();
        JLabel moldeQuadrado2 = new JLabel();
        JLabel moldeQuadrado3 = new JLabel();

        JPanel painelGenius = new JPanel(new BorderLayout());
        JPanel painelBingo = new JPanel(new BorderLayout());
        JPanel painelJogoDaMemoria = new JPanel(new BorderLayout());
        JPanel containerBotoesBingo = new JPanel(new GridLayout(0, 1, 0, 10));

        painelGenius.setPreferredSize(new Dimension(250, 300));
        painelJogoDaMemoria.setPreferredSize(new Dimension(250, 300));

        URL urlGenius = getClass().getResource("/imagens/GeniusImage.png");
        if(urlGenius == null) { 
            throw new RuntimeException("Não foi possível encontrar a imagem: GeniusImage.png"); 
        }
        ImageIcon iconeOriginal = new ImageIcon(urlGenius);
        Image imgRedimensionada = iconeOriginal.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        moldeQuadrado1.setIcon(new ImageIcon(imgRedimensionada));

        URL urlBingo = getClass().getResource("/imagens/BingoImage.png");
        if(urlBingo == null) { 
            throw new RuntimeException("Não foi possível encontrar a imagem: BingoImage.png"); 
        }
        iconeOriginal = new ImageIcon(urlBingo);
        imgRedimensionada = iconeOriginal.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        moldeQuadrado2.setIcon(new ImageIcon(imgRedimensionada));

        URL urlJogoDaMemoria = getClass().getResource("/imagens/JogoDaMemoriaImage.png");
        if(urlJogoDaMemoria == null) { 
            throw new RuntimeException("Não foi possível encontrar a imagem: JogoDaMemoriaImage.png"); 
        }
        iconeOriginal = new ImageIcon(urlJogoDaMemoria);
        imgRedimensionada = iconeOriginal.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        moldeQuadrado3.setIcon(new ImageIcon(imgRedimensionada));

        

        //Monta os painéis

        painelGenius.add(moldeQuadrado1, BorderLayout.NORTH);
        painelGenius.add(botaoGenius, BorderLayout.SOUTH);

        painelBingo.add(moldeQuadrado2, BorderLayout.NORTH);
        containerBotoesBingo.add(botaoBingo);
        if(admin){
            JButton botaoSortearBingo = new JButton("Sortear Bingo");
            botaoSortearBingo.setFont(fontePadrao);
            botaoSortearBingo.addActionListener(event -> {
                java.awt.EventQueue.invokeLater(() -> new TelaSorteio().setVisible(true));
            });
            containerBotoesBingo.add(botaoSortearBingo);
        }
        containerBotoesBingo.setBorder(BorderFactory.createEmptyBorder(12,0,0,0));
        painelBingo.add(containerBotoesBingo, BorderLayout.SOUTH);

        painelJogoDaMemoria.add(moldeQuadrado3, BorderLayout.NORTH);
        painelJogoDaMemoria.add(botaoJogoDaMemoria, BorderLayout.SOUTH);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0; // Não expande verticalmente
        add(painelJogoDaMemoria, gbc);
        
        gbc.gridx = 1;
        add(painelBingo, gbc);
        
        gbc.gridx = 2;
        add(painelGenius, gbc);

        setVisible(true);

    }

    //==========================================================

    public void exibirMenuPrincipal(){

        setVisible(true);

    }

    //==========================================================

    public void executarJogo(Jogo jogoEscolhido){

        setVisible(false);
        jogoEscolhido.setMainApp(this);
        jogoEscolhido.idPessoa = idGerado;
        jogoEscolhido.iniciarTutorial();


    }

    //==========================================================

    

}