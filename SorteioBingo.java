import java.util.Random;
import java.util.HashSet;
import java.util.Set;

class SorteioBingo {
    private Random random;
    private String numero;
    private Set<Integer> sorteados;
    private Main mainApp;

    public SorteioBingo() {

        random = new Random();
        sorteados = new HashSet<>();

    }

    public String sortearNumero(){
        int num = 0;

        if (sorteados.size() >= 75) {
            return null; 
        }

        do {
            num = random.nextInt(75) + 1;
        } while(sorteados.contains(num));

        sorteados.add(num);
        
        if(num > 0 && num < 16){
            numero = "B" + num;
        } else if(num > 15 && num < 31){
            numero = "I" + num;
        } else if(num > 30 && num < 46){
            numero = "N" + num;
        } else if(num > 45 && num < 61){
            numero = "G" + num;
        } else if(num > 60 && num < 76){
            numero = "O" + num;
        }

        return numero;
    }

    public void reiniciar() {
        sorteados.clear();
    }

    public int quantidadeSorteados() {
        return sorteados.size();
    }

    public Set<Integer> getSorteados() {
        return new HashSet<>(sorteados);
    }

    public void setMainApp(Main main){

        this.mainApp = main;

    }

    public void finalizar(){

        if(mainApp != null){

            mainApp.exibirMenuPrincipal();

        }

    }

    public void iniciar(){

        new TelaSorteio(this).setVisible(true);
        
    }
}