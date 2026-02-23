# Mapeador de Bolhas com DFS

Analisa uma rede inteira para descobrir quantos grupos isolados (bolhas/componentes conexos) existem, onde as pessoas de um grupo não têm nenhuma ligação com o resto da rede.

### O que foi usado:
* **Estrutura:** Grafo Não-Direcionado.
* **Algoritmo:** Busca em Profundidade (DFS - Depth-First Search).
* **Estruturas de Dados:** `HashSet` para a "prancheta global" de visitados e Recursão para mergulhar nas conexões.

### Como funciona:
O algoritmo varre a lista de pessoas. Se encontrar alguém que ainda não pertence a nenhuma bolha, ele aciona o DFS. O DFS mergulha recursivamente de amigo em amigo até esgotar todas as conexões daquele grupo, pintando todo mundo e salvando na lista da bolha atual.