BattleShip
==========

Jogo Batalha Naval desenvolvido em Java usando aplicação de Padrões de Projeto.

Batalha Naval é um jogo de tabuleiro de dois jogadores, no qual os jogadores têm de adivinhar em que quadrados estão os navios dos oponentes. o objetivo é derrubar os barcos do oponente adversário, ganha quem derrubar todos oa navios adversários primeiro.

O tabuleiro poderá ser configurado em três níveis de dificuldade:

1. 09x09 posições
2. 12x12 posições
3. 15x15 posições

Além disso o jogo poderá ser configurado das seguintes maneiras:

1. Dois jogadores humanos, com a distribuição da frota no tabuleiro pelo computador. Nesta configuração basta mostrar dois tabuleiros, um para cada jogador realizar seus tiros.

2. Dois jogadores humanos, com a distribuição da frota realizada por cada jogador. Nesta configuração, o primeiro tabuleiro é mostrado e o jogador faz a distribuição da frota. Em seguida, a frota é escondida do oponente. Os mesmos passos são seguidos para o tabuleiro 2.

Cada jogador coloca seus navios nas posições, alinhados horizontalmente ou verticalmente. O número de navios permitidos é igual para ambos jogadores e os navios não podem se sobrepor.

Os tiros são realizados em turnos. Em cada turno um jogador diz um quadrado no tabuleiro do oponente, se houver um navio nesse quadrado, é colocada uma marca que significa que a frota foi atingida, senão houver é colocada uma marca indicando que o tiro caiu na água.

Os Navios:

1 Porta-Aviões (5 quadrados)
1 Couraçado (4 quadrados)
2 Cruzadores (3 quadrados)
3 Barcos (2 quadrados)
4 Submarinos (1 quadrado)
