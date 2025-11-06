public class JogoDaMemoria extends Jogo{

    private Carta mesa[][];
    private int quantidadePar;

    public enum TipoFigura{

        Coracao("Coracao.png"),
        Estrela("Estrela.png"),
        Lua("Lua.png"),
        Nuvem("Nuvem.png"),
        Raio("Raio.png"),
        Sol("Sol.png"),
        Trevo("Trevo.png"),
        Triangulo("Triangulo.png");

        private String nomeArquivo;

        TipoFigura(String nomeArquivo){

            this.nomeArquivo = nomeArquivo;

        }

        public String getNomeArquivo() {

            return this.nomeArquivo;
        
        }
    }

    //==========================================================

    public void gerarMesa(){



    }

    //==========================================================

    public void iniciar(){



    }

    //==========================================================

    public void jogar(){



    }

    //==========================================================

    public void finalizar(){



    }

    //==========================================================

}