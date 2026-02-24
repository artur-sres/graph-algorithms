# Buscador de Voos com Dijkstra

Resolve o problema de encontrar o melhor caminho entre duas cidades em uma rede de rotas.

### O que foi usado:
* **Estrutura:** Grafo Direcionado.
* **Algoritmo:** Algoritmo de Dijkstra (caminho mínimo).
* **Estruturas de Dados:** `PriorityQueue` (Fila de Prioridade) para garantir matematicamente que as rotas mais baratas sejam processadas primeiro, e `HashMap` para guardar o menor custo conhecido de cada cidade e rastrear os pais para reconstruir a rota.

### Como funciona:
Ao informar uma origem e um destino (ex: "Lisboa" e "Berlim"), o algoritmo explora a rede avaliando o custo financeiro e a duração da viagem combinados. Ele utiliza a Fila de Prioridade para puxar sempre a opção mais vantajosa disponível no momento. Quando o destino final é retirado da fila, ele faz a engenharia reversa lendo o mapa de predecessores para devolver o melhor caminho.
