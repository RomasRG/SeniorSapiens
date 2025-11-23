import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaCadastroAdmin extends JFrame{
    

    private Font fonteNegrito = new Font("Arial", Font.BOLD, 24);
    private Font fontePadrao = new Font("Arial", Font.PLAIN, 24);

    private BancoDeDados bancoDeDados = new BancoDeDados();

    public TelaCadastroAdmin(){

        super("Tela Cadastro Admin");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Painel Superior
        JPanel painelTitulo = new JPanel(new FlowLayout());
        painelTitulo.setBorder(new EmptyBorder(0, 0, 30, 0));
        JLabel labelTitulo = new JLabel("Cadastro de Administrador");
        labelTitulo.setFont(fonteNegrito);
        painelTitulo.add(labelTitulo);

        add(painelTitulo, BorderLayout.NORTH);

        //Painel Central
        JPanel painelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        painelCentral.setBorder(new EmptyBorder(20, 0, 20, 0));

        JLabel textoNome = new JLabel("Nome: ");
        JLabel textoIdade = new JLabel("Idade: ");
        JLabel textoEmail = new JLabel("Email: ");
        JLabel textoSenha = new JLabel("Senha: ");
        JLabel textoConfirmaSenha = new JLabel("Confirmação de Senha");

        textoNome.setFont(fontePadrao);
        textoIdade.setFont(fontePadrao);

        textoNome.setHorizontalAlignment(SwingConstants.RIGHT);
        textoIdade.setHorizontalAlignment(SwingConstants.RIGHT);
        textoEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        textoSenha.setHorizontalAlignment(SwingConstants.RIGHT);
        textoConfirmaSenha.setHorizontalAlignment(SwingConstants.RIGHT);

        JTextField cxNome = new JTextField(15);
        JTextField cxIdade = new JTextField(15);
        JTextField cxEmail = new JTextField(15);
        JTextField cxSenha = new JTextField(15);
        JTextField cxConfirmaSenha = new JTextField(15);

        cxNome.setFont(fontePadrao);
        cxIdade.setFont(fontePadrao);
        cxEmail.setFont(fontePadrao);
        cxSenha.setFont(fontePadrao);
        cxConfirmaSenha.setFont(fontePadrao);

        //Configuração GridBagConstraints

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Primeira Coluna
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelCentral.add(textoNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painelCentral.add(textoIdade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painelCentral.add(textoEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        painelCentral.add(textoSenha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        painelCentral.add(textoConfirmaSenha, gbc);

        //Segunda Coluna

        gbc.gridx = 1;
        gbc.gridy = 0;
        painelCentral.add(cxNome, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        painelCentral.add(cxIdade, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        painelCentral.add(cxEmail, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        painelCentral.add(cxSenha, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        painelCentral.add(cxConfirmaSenha, gbc);

        //-------

        add(painelCentral, BorderLayout.CENTER);

        //Painel Inferior
        JPanel painelInferior = new JPanel(new GridLayout(2,1, 0,15));
        painelInferior.setBorder(new EmptyBorder(20, 10, 10, 10));

        JButton botaoCadastro = new JButton("Cadastrar");
        JButton botaoTelaAdmin = new JButton("Admin");
        
        botaoCadastro.setFont(fonteNegrito);
        botaoTelaAdmin.setFont(fonteNegrito);

        botaoCadastro.addActionListener(event ->{
            GerenciadorDeSom.tocarClique();

            String nome = cxNome.getText();
            String idade = cxIdade.getText();
            String email = cxEmail.getText();
            String senha = cxSenha.getText();
            String confirmaSenha = cxConfirmaSenha.getText();

            if(nome.trim().isEmpty()){

                String textoFormatado = "Por favor, insira um nome.";
                JLabel mensagem = new JLabel(textoFormatado);
                mensagem.setFont(fontePadrao);

                JOptionPane.showMessageDialog(
                    null,
                    mensagem,
                    "Erro ao cadastrar.",
                    1
                );
            }
            else if(idade.trim().isEmpty()){

                String textoFormatado = "Por favor, insira uma idade.";
                JLabel mensagem = new JLabel(textoFormatado);
                mensagem.setFont(fontePadrao);

                JOptionPane.showMessageDialog(
                    null,
                    mensagem,
                    "Erro ao cadastrar.",
                    1
                );
            } else if(email.trim().isEmpty()){
                String textoFormatado = "Por favor, insira um email.";
                JLabel mensagem = new JLabel(textoFormatado);
                mensagem.setFont(fontePadrao);

                JOptionPane.showMessageDialog(
                    null,
                    mensagem,
                    "Erro ao cadastrar.",
                    1
                );
            } else if(senha.trim().isEmpty()){
                String textoFormatado = "Por favor, insira uma senha.";
                JLabel mensagem = new JLabel(textoFormatado);
                mensagem.setFont(fontePadrao);

                JOptionPane.showMessageDialog(
                    null,
                    mensagem,
                    "Erro ao cadastrar.",
                    1
                );
            } else if(confirmaSenha.trim().isEmpty()){
                String textoFormatado = "Por favor, insira a confirmação de senha.";
                JLabel mensagem = new JLabel(textoFormatado);
                mensagem.setFont(fontePadrao);

                JOptionPane.showMessageDialog(
                    null,
                    mensagem,
                    "Erro ao cadastrar.",
                    1
                );
            }else if(confirmaSenha != senha){
                String textoFormatado = "As senhas são diferentes.";
                JLabel mensagem = new JLabel(textoFormatado);
                mensagem.setFont(fontePadrao);

                JOptionPane.showMessageDialog(
                    null,
                    mensagem,
                    "Erro ao cadastrar.",
                    1
                );
            } else {

                int valIdade;

                try{
                    valIdade = Integer.parseInt(idade);
                    int idGerado = bancoDeDados.cadastroAdmin(nome, valIdade, email, senha);
                    dispose();
                    new Main(idGerado, true);
                }catch(NumberFormatException numberFormatException){

                    String textoFormatado = "Por favor, a idade deve ser um número inteiro.";
                    JLabel mensagem = new JLabel(textoFormatado);
                    mensagem.setFont(fontePadrao);

                    JOptionPane.showMessageDialog(
                        null,
                        mensagem,
                        "Erro ao cadastrar.",
                        1
                    );
                }
            }

        });

        botaoTelaAdmin.addActionListener(event ->{
            GerenciadorDeSom.tocarClique();

        });

        painelInferior.add(botaoCadastro);
        painelInferior.add(botaoTelaAdmin);

        add(painelInferior, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new TelaCadastroAdmin().setVisible(true);
    }

}
