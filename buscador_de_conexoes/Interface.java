import java.util.List;

import javax.swing.JOptionPane;

public class Interface {

    public static void iniciar(Grafo grafo) {
        String mensagemInicial = "Interface para o buscador de conexões utilizando o algoritmo de busca em largura (BFS).";
        String[] opcoes = {"Lista de Adjacência", "Testar", "Encerrar"};

        while(true) {
            int opcaoEscolhida = JOptionPane.showOptionDialog(null, mensagemInicial, "Buscador de Conexões", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[2]);
            
            switch (opcaoEscolhida){
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
                        String p1 = JOptionPane.showInputDialog(null, "Digite o nome da primeira pessoa:", "Teste de Conexão", JOptionPane.QUESTION_MESSAGE);
                        String p2 = JOptionPane.showInputDialog(null, "Digite o nome da segunda pessoa:", "Teste de Conexão", JOptionPane.QUESTION_MESSAGE);
                        if (p1 == null || p2 == null || p1.trim().isEmpty() || p2.trim().isEmpty()) {
                            continue; 
                        }
                        List<String> resultado = new AlgoritmoBFS().findGrauAmizade(p1, p2, grafo);

                        if(resultado != null) {
                            int grau = resultado.size() - 1; //Não deveria estar aqui
                            String caminho = String.join(" -> ", resultado);
                            JOptionPane.showMessageDialog(null, "Grau de amizade entre " + p1 + " e " + p2 + " é igual a " + grau + ": " + caminho, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Não há conexão entre " + p1 + " e " + p2, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (Exception e) {
                        String errorMessage = "Erro ao buscar grau de amizade. Verifique se os nomes estão corretos e tente novamente.\n" + e.getMessage();
                        JOptionPane.showMessageDialog(null, errorMessage, "Erro", JOptionPane.ERROR_MESSAGE);
                        continue;
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
