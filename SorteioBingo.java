import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class SorteioBingo {
    private Random random;
    private String numero;

    public String sortearNumero(){
        Set<Integer> sorteados = new HashSet<>();
        random = new Random();
        int num = 0;

        do{
        num = random.nextInt(75) + 1;
        } while(sorteados.contains(num));

        sorteados.add(num);
        
        if(num > 0 && num < 16){
            numero = 'B' + Integer.toString(num);
        }
        if(num > 15 && num < 31){
            numero = 'I' + Integer.toString(num);
        }
        if(num > 30 && num < 46){
            numero = 'N' + Integer.toString(num);
        }
        if(num > 45 && num < 61){
            numero = 'G' + Integer.toString(num);
        }
        if(num > 60 && num < 76){
            numero = 'O' + Integer.toString(num);
        }

        return numero;
    }
}
