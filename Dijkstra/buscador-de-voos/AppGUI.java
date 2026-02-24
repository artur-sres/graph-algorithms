import java.util.List;

import javax.swing.JOptionPane;

public class AppGUI {

    public static void iniciar(Grafo grafo) {
        String mensagemInicial = "Interface para o buscador de voos utilizando o algoritmo de Dijkstra.";
        String[] opcoes = {"Lista de Adjacência", "Testar", "Encerrar"};

        while(true){
            int opcaoEscolhida = JOptionPane.showOptionDialog(null, mensagemInicial, "Buscador de Voos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[2]);

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
                        String c1 = JOptionPane.showInputDialog(null, "Digite o nome da primeira cidade:","Teste Dijkstra" , JOptionPane.QUESTION_MESSAGE);
                        String c2 = JOptionPane.showInputDialog(null, "Digite o nome da segunda cidade:", "Teste Dijkstra", JOptionPane.QUESTION_MESSAGE);
                        if (c1 == null || c2 == null || c1.trim().isEmpty() || c2.trim().isEmpty()) {
                            continue; 
                        }
                        List<String> resultado = AlgoritmoDijkstra.melhorRota(c1, c2, grafo);

                        if(resultado != null) {

                            JOptionPane.showMessageDialog(null, "A melhor rota entre " + c1 + " e " + c2 + " é :"  + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Não há uma rota entre " + c1 + " e " + c2, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao calcular a melhor rota. Verifique os nomes das cidades e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

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