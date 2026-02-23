# Algoritmos em Grafos

Este repositório é um ambiente de estudos e testes dedicado à implementação prática de teoria dos grafoss em Java.

Em vez de ser único, este repositório funciona como uma coleção de mini-projetos independentes. Cada pasta contém o seu próprio contexto, a sua própria estrutura de Grafo e um caso de uso do mundo real para um algoritmo específico, que no geal são bem simples.

### Algoritmos Implementados

Até ao momento, o laboratório contém:

* **[BFS / Buscador de Conexões](./BFS/buscador_de_conexoes/):** Implementação de Busca em Largura (Breadth-First Search) para encontrar o menor caminho e o grau de separação entre dois nós.
* **[DFS / Mapeador de Bolhas](./DFS/mapeador-de-bolhas/):** Implementação de Busca em Profundidade (Depth-First Search) para identificar componentes conexos e mapear "bolhas" isoladas dentro de uma rede.

### Como Executar
Como cada algoritmo é independente, basta navegar até à pasta desejada, compilar os ficheiros `.java` e executar a classe `Main`. Cada projeto possui uma interface gráfica simples (Swing) para interagir com o algoritmo e carregar os dados a partir de ficheiros `.csv`.