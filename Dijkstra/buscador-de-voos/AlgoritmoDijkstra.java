import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AlgoritmoDijkstra {


    public static List<String> melhorRota(String origem, String destino, Grafo grafo){

        PriorityQueue<Answer> fila = new PriorityQueue<>(Comparator.comparingInt(e -> e.custoAcumulado));
        
        Map<String, Integer> distancias = new HashMap<>();
        Map<String, String> predecessores = new HashMap<>();
        Map<String, Boolean> visitados = new HashMap<>();

        distancias.put(origem, 0);
        fila.add(new Answer(origem, 0));

        while (!fila.isEmpty()) {
            Answer atualAnswer = fila.poll();
            String atual = atualAnswer.cidade;

            if (atual.equals(destino)) {
                List<String> rota = new LinkedList<>();
                String passo = destino;
                while (passo != null) {
                    rota.add(0, passo);
                    passo = predecessores.get(passo);
                }
                return rota;
            }

            if (visitados.getOrDefault(atual, false)) {
                continue;
            }
            visitados.put(atual, true);

            for (Voo voo : grafo.getListaAdjacencia().getOrDefault(atual, new LinkedList<>())) {
                String destinoVoo = voo.getDestino();
                double pesoVoo = (voo.getCusto() * 0.6) + (voo.getDuracao() * 0.);

                
                if(distancias.getOrDefault(destinoVoo, Integer.MAX_VALUE) > atualAnswer.custoAcumulado + pesoVoo){
                    distancias.put(destinoVoo, (int)(atualAnswer.custoAcumulado + pesoVoo));
                    predecessores.put(destinoVoo, atual);
                    fila.add(new Answer(destinoVoo, (int)(atualAnswer.custoAcumulado + pesoVoo)));
                }
                
                    
                }
            }
        
        return null;
    }
}

