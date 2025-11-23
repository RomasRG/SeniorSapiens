import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaCadastroPessoa extends JFrame{
    
    private Font fonteNegrito = new Font("Arial", Font.BOLD, 24);
    private Font fontePadrao = new Font("Arial", Font.PLAIN, 24);

    private BancoDeDados bancoDeDados = new BancoDeDados();

    public TelaCadastroPessoa(){

        super("Tela Cadastro Usuário");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Painel Superior
        JPanel painelTitulo = new JPanel(new FlowLayout());
        painelTitulo.setBorder(new EmptyBorder(0, 0, 30, 0));
        JLabel labelTitulo = new JLabel("Cadastro de Usuário");
        labelTitulo.setFont(fonteNegrito);
        painelTitulo.add(labelTitulo);

        add(painelTitulo, BorderLayout.NORTH);

        //Painel Central
        JPanel painelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        painelCentral.setBorder(new EmptyBorder(20, 0, 20, 0));

        JLabel textoNome = new JLabel("Nome: ");
        JLabel textoIdade = new JLabel("Idade: ");

        textoNome.setFont(fontePadrao);
        textoIdade.setFont(fontePadrao);

        textoNome.setHorizontalAlignment(SwingConstants.RIGHT);
        textoIdade.setHorizontalAlignment(SwingConstants.RIGHT);

        JTextField cxNome = new JTextField(15);
        JTextField cxIdade = new JTextField(15);

        cxNome.setFont(fontePadrao);
        cxIdade.setFont(fontePadrao);

        //Configuração GridBagConstraints

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        painelCentral.add(textoNome, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        painelCentral.add(cxNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painelCentral.add(textoIdade, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        painelCentral.add(cxIdade, gbc);

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
            }
            else{

                int valIdade;

                try{
                    valIdade = Integer.parseInt(idade);
                    int idGerado = bancoDeDados.cadastroPessoa(nome, valIdade);
                    dispose();
                    new Main(idGerado, false);
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
            dispose();
            new TelaCadastroAdmin().setVisible(true);

        });

        painelInferior.add(botaoCadastro);
        painelInferior.add(botaoTelaAdmin);

        add(painelInferior, BorderLayout.SOUTH);
    }

}
