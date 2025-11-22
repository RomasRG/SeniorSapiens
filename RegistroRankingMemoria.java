public class RegistroRankingMemoria {
      
    private int id;
    private String nome;
    private int idade;
    private int pontuacao;
    private int paresEncontrados;

    public RegistroRankingMemoria(int id, String nome, int idade, int pontuacao, int paresEncontrados) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.pontuacao = pontuacao;
        this.paresEncontrados = paresEncontrados;
    }

    // Getters para acessar os dados na  tela
    public int getID(){ return id; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public int getPontuacao() { return pontuacao; }
    public int getParesEncontrados() { return paresEncontrados; }
    

}
