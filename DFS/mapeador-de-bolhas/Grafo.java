import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Grafo {
    private Map<String, HashSet<String>> listaAjacencia = new HashMap<>();

    //Construtor do grafo, recebe o caminho do arquivo CSV e preenche a lista de adjacência
    public Grafo(String endereco) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(endereco))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                addNode(partes);
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNode(String[] node){
        //Adiciona os nós na lista de adjacência, utilizando o método computeIfAbsent para criar um novo HashSet caso a chave ainda não exista
        listaAjacencia.computeIfAbsent(node[0].trim(), key -> new HashSet<>()).add(node[1].trim());
        listaAjacencia.computeIfAbsent(node[1].trim(), key -> new HashSet<>()).add(node[0].trim());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String key : listaAjacencia.keySet()) {
            result.append(key).append(": ").append(listaAjacencia.get(key)).append("\n");
        }
        return result.toString();
    }

    public Map<String, HashSet<String>> getListaAjacencia() {
        return listaAjacencia;
    }

    
}
    
    