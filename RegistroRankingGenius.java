public class RegistroRankingGenius {
    private int id;
    private String nome;
    private int idade;
    private int pontuacao;

    public RegistroRankingGenius(int id, String nome, int idade, int pontuacao) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.pontuacao = pontuacao;
    }

    // Getters para acessar os dados na tela
    public int getID(){ return id; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public int getPontuacao() { return pontuacao; }
}
