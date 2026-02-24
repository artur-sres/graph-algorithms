import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
    private Map<String, List<Voo>> listaAdjacencia = new HashMap<>();

    public Grafo(String endereco) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(endereco))) {
            String linha = br.readLine(); // Pula o cabeçalho
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                addNode(partes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNode(String[] partes){
        String origem = partes[0].trim();
        String destino = partes[1].trim();
        int preco = Integer.parseInt(partes[2].trim());
        int duracao = Integer.parseInt(partes[3].trim()); 

        listaAdjacencia.computeIfAbsent(origem, key -> new ArrayList<>()).add(new Voo(destino, preco, duracao));
        
        // Se quiser assumir que os voos têm sempre volta pelo mesmo preço e tempo, descomente a linha abaixo:
        // listaAdjacencia.computeIfAbsent(destino, key -> new ArrayList<>()).add(new Voo(origem, preco, duracao));
    }

    public Map<String, List<Voo>> getListaAdjacencia() {
        return listaAdjacencia;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Voo>> entry : listaAdjacencia.entrySet()) {
            sb.append(entry.getKey()).append(" -> ");
            for (Voo voo : entry.getValue()) {
                sb.append(voo.getDestino()).append(" (Custo: ").append(voo.getCusto()).append(", Duração: ").append(voo.getDuracao()).append(" min), ");
            }
            sb.setLength(sb.length() - 2); // Remove a última vírgula e espaço
            sb.append("\n");
        }
        return sb.toString();
    }
}