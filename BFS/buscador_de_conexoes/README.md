# Buscador de Conexões com BFS

Resolve o problema de encontrar o menor caminho entre duas pessoas em uma rede de contatos.

### O que foi usado:
* **Estrutura:** Grafo Não-Direcionado.
* **Algoritmo:** Busca em Largura (BFS - Breadth-First Search).
* **Estruturas de Dados:** `LinkedList` para explorar camada por camada, e `HashMap` para rastrear quem descobriu quem (Backtracking) e reconstruir a rota.

### Como funciona:
Ao informar duas pessoas (ex: "Ana" e "Wagner"), o algoritmo se expande em ondas. Quando o destino é encontrado, ele faz a engenharia reversa lendo o mapa de pais para devolver o caminho exato e o grau de separação entre eles.
