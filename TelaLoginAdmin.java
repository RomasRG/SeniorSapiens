import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaLoginAdmin extends JFrame{
    
    private Font fonteNegrito = new Font("Arial", Font.BOLD, 24);
    private Font fontePadrao = new Font("Arial", Font.PLAIN, 24);

    private BancoDeDados bancoDeDados = new BancoDeDados();

    public TelaLoginAdmin(){

        super("Tela Login Admnistrador");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Painel Superior
        JPanel painelTitulo = new JPanel(new FlowLayout());
        painelTitulo.setBorder(new EmptyBorder(0, 0, 30, 0));
        JLabel labelTitulo = new JLabel("Login de Admin");
        labelTitulo.setFont(fonteNegrito);
        painelTitulo.add(labelTitulo);

        add(painelTitulo, BorderLayout.NORTH);

        //Painel Central
        JPanel painelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        painelCentral.setBorder(new EmptyBorder(20, 0, 20, 0));

        JLabel textoEmail = new JLabel("Email: ");
        JLabel textoSenha = new JLabel("Senha: ");

        textoEmail.setFont(fontePadrao);
        textoSenha.setFont(fontePadrao);

        textoEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        textoSenha.setHorizontalAlignment(SwingConstants.RIGHT);

        JTextField cxEmail = new JTextField(15);
        JTextField cxSenha = new JTextField(15);

        cxEmail.setFont(fontePadrao);
        cxSenha.setFont(fontePadrao);

        //Configuração GridBagConstraints

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        painelCentral.add(textoEmail, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        painelCentral.add(cxEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painelCentral.add(textoSenha, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        painelCentral.add(cxSenha, gbc);

        //-------

        add(painelCentral, BorderLayout.CENTER);

        //Painel Inferior
        JPanel painelInferior = new JPanel(new GridLayout(2,1, 0,15));
        painelInferior.setBorder(new EmptyBorder(20, 10, 10, 10));

        JButton botaoLogin = new JButton("Login");
        JButton botaoVoltar = new JButton("Voltar");
        
        botaoLogin.setFont(fonteNegrito);
        botaoVoltar.setFont(fonteNegrito);

        botaoLogin.addActionListener(event ->{
            GerenciadorDeSom.tocarClique();

            String email = cxEmail.getText();
            String senha = cxSenha.getText();

            if(email.trim().isEmpty()){

                String textoFormatado = "Por favor, insira um email.";
                JLabel mensagem = new JLabel(textoFormatado);
                mensagem.setFont(fontePadrao);

                JOptionPane.showMessageDialog(
                    null,
                    mensagem,
                    "Erro ao cadastrar.",
                    1
                );
            }
            else if(senha.trim().isEmpty()){

                String textoFormatado = "Por favor, insira a senha.";
                JLabel mensagem = new JLabel(textoFormatado);
                mensagem.setFont(fontePadrao);

                JOptionPane.showMessageDialog(
                    null,
                    mensagem,
                    "Erro ao cadastrar.",
                    1
                );
            }
            else{

                int idAdmin = bancoDeDados.loginAdmin(email, senha);

                if(idAdmin != -1){

                    JLabel msgSucesso = new JLabel("Logado com Sucesso!");
                    msgSucesso.setFont(fontePadrao);

                    JOptionPane.showMessageDialog(null, msgSucesso);
                    dispose();
                    new Main(idAdmin, true);
                } else {

                    JLabel msgErro = new JLabel("Email ou senha incorretos.");
                    msgErro.setFont(fontePadrao);

                    JOptionPane.showMessageDialog(null, msgErro);
                }

            }

        });

        botaoVoltar.addActionListener(event ->{
            GerenciadorDeSom.tocarClique();
            dispose();
            new TelaCadastroPessoa().setVisible(true);

        });

        painelInferior.add(botaoLogin);
        painelInferior.add(botaoVoltar);

        add(painelInferior, BorderLayout.SOUTH);
    }

}


