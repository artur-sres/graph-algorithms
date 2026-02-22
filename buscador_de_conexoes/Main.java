import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String[] args) {
        
        try {
            // Define o look and feel para o do sistema operacional atual 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            //Cria o grafo, importando os dados do arquivo CSV para o construtor e inicia a interface para o usuário
            Grafo grafo = new Grafo("buscador_de_conexoes/grafo.csv");
            AppGUI.iniciar(grafo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}