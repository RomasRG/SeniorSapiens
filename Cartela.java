import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Cartela {

    private int[][] numeros;
    private boolean[][] marcados;
    private Random random;

    //contrutor
    public Cartela(){
        this.numeros = new int[5][5];
        this.marcados = new boolean[5][5];
        gerarCartela();
    }
    
    //==========================================================

    public void gerarCartela(){
        Set<Integer> usados = new HashSet<>();
        
        //faz uma varredura na cartela para inserir os numeros
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                //ignora o espaco livre da cartela (centro)
                if(i == 2 && j == 2){
                    numeros[i][j] = 0;
                    marcados[i][j] = true;
                    continue;
                }

                //gera um numero aleatorio, compara se ele ja nao foi adicionado e adiciona em sua respectiva coluna
                int num = 0;
                do{
                    num = random.nextInt(15) + 1 + (j * 15);
                } while(usados.contains(num));

                usados.add(num);
                numeros[i][j] = num;
            }
        }
    }

    //==========================================================

    public boolean verificaCartela(){
        //procura na cartela inteira por um numero nao marcado, caso nao encontre retorna true
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(!marcados[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
}
