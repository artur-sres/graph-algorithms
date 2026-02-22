import java.util.List;

import javax.swing.JOptionPane;

public class AppGUI {

    public static void iniciar(Grafo grafo) {
        String mensagemInicial = "Interface para o buscador de bolhas utilizando o algoritmo de busca em profundidade (DFS).";
        String[] opcoes = {"Lista de Adjacência", "Testar", "Encerrar"};

        while(true){
            int opcaoEscolhida = JOptionPane.showOptionDialog(null, mensagemInicial, "Buscador de Bolhas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[2]);

            switch (opcaoEscolhida) {
                case 0:
                    String listaAdjacencia = grafo.toString();
                    try {
                        JOptionPane.showMessageDialog(null, listaAdjacencia, "Lista de Adjacência", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao exibir a lista de adjacência.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                    
                case 1:
                    try {
                        List <List<String>> bolhasEncontradas = AlgoritmoDFS.encontrarBolhas(grafo);
                        if (bolhasEncontradas == null) {
                            JOptionPane.showMessageDialog(null, "Nenhuma bolha encontrada.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        } else {
                            StringBuilder mensagem = new StringBuilder("Bolhas encontradas:\n");
                            for (int i = 0; i < bolhasEncontradas.size(); i++) {
                                mensagem.append("Bolha ").append(i + 1).append(": ").append(bolhasEncontradas.get(i)).append("\n");
                            }
                            JOptionPane.showMessageDialog(null, mensagem.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao encontrar as bolhas.", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    break;

                case 2:
                    System.exit(0);
                    break;
                
                case JOptionPane.CLOSED_OPTION:
                    System.exit(0);
                    break;
            }
        }
    }

}
