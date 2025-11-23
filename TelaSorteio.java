import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaSorteio extends JFrame {    
    // Componentes da interface
    private JButton btnSortear;
    private JButton btnReiniciar;
    private JLabel lblUltimoNumero;
    private JTextArea txtNumerosSorteados;
    private JScrollPane scrollPane;
    private JLabel lblContador;
    private SorteioBingo logicaSorteioBingo;
    
    // Controle do jogo
    private List<String> historicoSorteios;
    private static final int MAX_NUMEROS = 75;

    public TelaSorteio(SorteioBingo logicaSorteioBingo) {
        this.logicaSorteioBingo = logicaSorteioBingo;
        initComponents();
        inicializarJogo();
    }

    private void initComponents() {
        setTitle("Sorteador de Bingo - B.I.N.G.O");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        addWindowListener(new java.awt.event.WindowAdapter() {

        public void windowClosing(java.awt.event.WindowEvent windowEvent) {

        GerenciadorDeSom.tocarClique();
        dispose();
        logicaSorteioBingo.finalizar();

        }});
        
        JPanel painelSuperior = new JPanel(new BorderLayout());
        painelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        
        JLabel lblTitulo = new JLabel("ÚLTIMO NÚMERO:");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        painelSuperior.add(lblTitulo, BorderLayout.NORTH);
        
        lblUltimoNumero = new JLabel("-");
        lblUltimoNumero.setFont(new Font("Arial", Font.BOLD, 72));
        lblUltimoNumero.setHorizontalAlignment(SwingConstants.CENTER);
        lblUltimoNumero.setForeground(new Color(0, 100, 0));
        painelSuperior.add(lblUltimoNumero, BorderLayout.CENTER);
        
        lblContador = new JLabel("Sorteados: 0/" + MAX_NUMEROS);
        lblContador.setFont(new Font("Arial", Font.PLAIN, 14));
        lblContador.setHorizontalAlignment(SwingConstants.CENTER);
        painelSuperior.add(lblContador, BorderLayout.SOUTH);
        
        add(painelSuperior, BorderLayout.NORTH);
        
        // Painel central - Lista de números sorteados
        JPanel painelCentral = new JPanel(new BorderLayout(5, 5));
        painelCentral.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        JLabel lblHistorico = new JLabel("Números Sorteados:");
        lblHistorico.setFont(new Font("Arial", Font.BOLD, 14));
        painelCentral.add(lblHistorico, BorderLayout.NORTH);
        
        txtNumerosSorteados = new JTextArea();
        txtNumerosSorteados.setEditable(false);
        txtNumerosSorteados.setFont(new Font("Monospaced", Font.BOLD, 14));
        txtNumerosSorteados.setLineWrap(true);
        txtNumerosSorteados.setWrapStyleWord(true);
        
        scrollPane = new JScrollPane(txtNumerosSorteados);
        scrollPane.setPreferredSize(new Dimension(450, 200));
        painelCentral.add(scrollPane, BorderLayout.CENTER);
        
        add(painelCentral, BorderLayout.CENTER);
        
        // Painel inferior - Botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        
        btnSortear = new JButton("SORTEAR NÚMERO");
        btnSortear.setFont(new Font("Arial", Font.BOLD, 16));
        btnSortear.setPreferredSize(new Dimension(200, 50));
        btnSortear.setBackground(new Color(0, 150, 0));
        btnSortear.setForeground(Color.WHITE);
        btnSortear.setFocusPainted(false);
        btnSortear.addActionListener(e -> sortearNumero());
        
        btnReiniciar = new JButton("REINICIAR");
        btnReiniciar.setFont(new Font("Arial", Font.BOLD, 14));
        btnReiniciar.setPreferredSize(new Dimension(150, 50));
        btnReiniciar.addActionListener(e -> inicializarJogo());
        
        painelBotoes.add(btnSortear);
        painelBotoes.add(btnReiniciar);
        
        add(painelBotoes, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
    }
    
    private void inicializarJogo() {
        historicoSorteios = new ArrayList<>();
        
        lblUltimoNumero.setText("-");
        txtNumerosSorteados.setText("");
        lblContador.setText("Sorteados: 0/" + MAX_NUMEROS);
        btnSortear.setEnabled(true);
    }
    
    private void sortearNumero() {
        String numeroSorteado = logicaSorteioBingo.sortearNumero();
        
        if (numeroSorteado == null) {
            JOptionPane.showMessageDialog(this, 
                "Todos os números já foram sorteados!", 
                "Fim do Jogo", 
                JOptionPane.INFORMATION_MESSAGE);
            btnSortear.setEnabled(false);
            return;
        }
        
        // Adicionar ao histórico
        historicoSorteios.add(numeroSorteado);
        
        // Atualizar último número com destaque da letra
        lblUltimoNumero.setText(numeroSorteado);
        
        // Mudar cor baseado na letra
        char letra = numeroSorteado.charAt(0);
        switch(letra) {
            case 'B': lblUltimoNumero.setForeground(new Color(0, 0, 200)); break;
            case 'I': lblUltimoNumero.setForeground(new Color(200, 0, 0)); break;
            case 'N': lblUltimoNumero.setForeground(new Color(0, 150, 0)); break;
            case 'G': lblUltimoNumero.setForeground(new Color(200, 100, 0)); break;
            case 'O': lblUltimoNumero.setForeground(new Color(150, 0, 150)); break;
        }
        
        // Atualizar contador
        int qtd = logicaSorteioBingo.quantidadeSorteados();
        lblContador.setText("Sorteados: " + qtd + "/" + MAX_NUMEROS);
        
        // Atualizar lista
        atualizarListaNumeros();
        
        // Verificar se acabou
        if (qtd >= MAX_NUMEROS) {
            btnSortear.setEnabled(false);
            JOptionPane.showMessageDialog(this, 
                "Todos os números foram sorteados!", 
                "Fim do Jogo", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void atualizarListaNumeros() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < historicoSorteios.size(); i++) {
            sb.append(historicoSorteios.get(i));
            
            if (i < historicoSorteios.size() - 1) {
                sb.append(" - ");
            }
            
            // Quebrar linha a cada 8 números para melhor visualização
            if ((i + 1) % 8 == 0 && i < historicoSorteios.size() - 1) {
                sb.append("\n");
            }
        }
        
        txtNumerosSorteados.setText(sb.toString());
        txtNumerosSorteados.setCaretPosition(txtNumerosSorteados.getDocument().getLength());
    }
}