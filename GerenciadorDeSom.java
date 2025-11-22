import javax.sound.sampled.*;
import java.net.URL;

public class GerenciadorDeSom {

    private static final String CAMINHO_CLIQUE = "/sons/click.wav";
    private static final String CAMINHO_ACERTO = "/sons/acerto.wav";
    private static final String CAMINHO_ERRO = "/sons/erro.wav";

    private static void tocar(String caminho) {
        try {
            URL url = GerenciadorDeSom.class.getResource(caminho);
            if (url == null) {
                System.err.println("Som não encontrado: " + caminho);
                return;
            }
            
            // Abre o arquivo de áudio
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            
            // Obtém um recurso de som do sistema (Clip)
            Clip clip = AudioSystem.getClip();
            
            // Abre o clip e carrega o áudio
            clip.open(audioIn);
            
            // Toca o som
            clip.start();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tocarClique() {
        tocar(CAMINHO_CLIQUE);
    }

    public static void tocarAcerto() {
        tocar(CAMINHO_ACERTO);
    }

    public static void tocarErro() {
        tocar(CAMINHO_ERRO);
    }
}