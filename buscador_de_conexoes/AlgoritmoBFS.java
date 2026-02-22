import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AlgoritmoBFS {
    public List<String> findGrauAmizade(String p1, String p2, Grafo grafo) {
        /* 
        As estruturas utilizadas para o algoritmo são: 
            Fila Encadeada para armazenar os nós a serem visitados, pois os nós das extremidades são constantemente modificados.
            Map para armazenar os nós visitados e seus pais, pois é necessário acessar os pais para reconstruir o caminho encontrado.
            Lista para armazenar o resultado final do caminho encontrado.
        */
        
        Map<String, HashSet<String>> listaAdjacencia = grafo.getListaAjacencia();
        LinkedList<String> fila = new LinkedList<>();
        Map<String, String> visitados = new HashMap<>();
        List<String> resultado = new ArrayList<>();

        fila.add(p1);
        visitados.put(p1, null);
        
        while(!fila.isEmpty()) {
            String atual = fila.remove();

            for(String adjacente : listaAdjacencia.get(atual)) {
                if(adjacente.equals(p2)) {
                    visitados.put(adjacente, atual);
                    resultado.add(adjacente);
                    String paiAux = visitados.get(adjacente);

                    while(!paiAux.equals(p1)) {
                        resultado.add(paiAux);
                        paiAux = visitados.get(paiAux);
                    }
                    
                    resultado.add(p1);
                    Collections.reverse(resultado);
                    return resultado;
                }
                if(!visitados.containsKey(adjacente)) {
                    visitados.put(adjacente, atual);
                    fila.add(adjacente);
                }
            }
        }  
        return null; 
    } 

}
