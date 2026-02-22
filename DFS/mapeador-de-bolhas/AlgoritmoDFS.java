import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AlgoritmoDFS {
    
    public static List<List<String>> encontrarBolhas(Grafo grafo) {
        List<List<String>> bolhasEncontradas = new ArrayList<>();
        LinkedList<String> bolha = new LinkedList<>();
        HashSet<String> visitado = new HashSet<>();
        
        for (String node : grafo.getListaAjacencia().keySet()) {
            if (!visitado.contains(node)) {
                bolha.clear();
                dfs(node, grafo, bolha, visitado);
                bolhasEncontradas.add(new ArrayList<>(bolha));
            }
        }
        if (bolhasEncontradas.size() > 1) {
            return bolhasEncontradas;
        } else {
            return null;
        }
    }
    
    private static void dfs(String node, Grafo grafo, LinkedList<String> bolha, HashSet<String> visitado) {
        visitado.add(node);
        bolha.add(0, node);
        for (String adjacente : grafo.getListaAjacencia().get(node)) {
            if (!visitado.contains(adjacente)) {
                dfs(adjacente, grafo, bolha, visitado);
            }
        }
    }

    @Override
    public String toString() {

        return null;
    }

}
