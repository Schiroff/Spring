# Jogo da Velha em Spring Boot

Este é um projeto de aplicação web funcional de jogo da velha. O Spring Boot facilita a configuração e a criação de aplicativos web, enquanto o Thymeleaf simplifica a integração de dados dinâmicos na interface do usuário.


## Classe “JogoVelha”:

Quando a aplicação for  executada, o método main é chamado, o método main invoca “SpringApplication.run”, que inicia o Spring Boot, o Spring Boot, por meio da anotação @SpringBootApplication, configura automaticamente a aplicação e inicia um servidor embutido.
Esta classe é usada como o ponto de entrada para a aplicação Spring Boot, fazendo a configuração e inicializando a aplicação para que seja executada a lógica do jogo.


## Classe “Game”:

Este código implementa a lógica completa do jogo da velha, ele permite o movimentos dos jogadores, faz a verificação de vitórias, empates e mantém o placar.

board = new char[3][3]: Usada para fazer a representação do tabuleiro do jogo.
currentPlayer = 'X': Indica qual o jogador da vez, “X” ou “O”
playerXWins = 0, playerOWins = 0: Utilizado para fazer a contagem das vitórias individuais.
public Game(): Inicializa o tabuleiro, define o jogador atual como 'X', inicializa o placar.
Chama o método “initializeBoard()” para preencher o tabuleiro com espaços vazios.
getBoard(): Mostra o estado atual do tabuleiro.
getCurrentPlayer(): Demonstra o jogador da vez..
getPlayerXWins(), getPlayerOWins(): Mostra as vitórias de cada jogador.
makeMove(int row, int col): Realiza um movimento no jogo, verifica vitória, empate ou troca de jogador.
initializeBoard(): Preenche o tabuleiro com espaços vazios.
switchPlayer(): Alterna o jogador atual.
checkWinner(int row, int col): Verifica se há um vencedor após um movimento.
checkDraw(): Verifica se o jogo terminou em empate.


## classe “ControleJogo”:

Responsável por gerenciar a interação entre a lógica do jogo e a interface web.

@Controller Annotation: Indica que esta classe é um controlador Spring MVC.

private Game game = new Game(): Cria uma instância da classe Game para gerenciar a lógica do jogo.

(@GetMapping("/")): Mapeamento para a Página Inicial.

showGame(Model model): Método chamado quando a aplicação é acessada.

Model model: Adiciona atributos ao modelo, como o estado atual do tabuleiro e informações sobre o jogador e placar. Retorna o nome do template Thymeleaf ("game") a ser renderizado.

(@PostMapping("/makeMove")): Mapeamento para Movimento 

makeMove(@RequestParam int row, @RequestParam int col): Método chamado quando um movimento é feito pelos jogadores.
@RequestParam: Obtém os parâmetros da solicitação HTTP.
Chama o método makeMove da instância game para processar o movimento.
Redireciona de volta para a página inicial após o movimento.
Mapeamento para Reiniciar o Placar (@RequestMapping("/resetScore")):

resetScore(): Método chamado quando a solicitação de reiniciar o placar é feita.
Chama o método resetScore da instância game para reiniciar o placar.
Redireciona de volta para a página inicial após reiniciar o placar.


## Arquivo Html “game.html”: 

Este Html forma o jogo da velha e o placar. Desempenha um papel central na apresentação e na interação do Jogo da Velha na web.


Fluxo:
“JogoVelha” inicia a aplicação Spring Boot.
“ControleJogo” lida com solicitações HTTP, chamando métodos na classe “Game”.
“Game” mantém a lógica do jogo, atualizando o estado do tabuleiro e placares.
O template HTML exibe dinamicamente o estado atual do jogo.


## Tecnologias Utilizadas

- Spring Boot
- Thymeleaf
- Java
- -Html
- Css


- # Autor

- Lucas Vinicius Schiroff
- Turma A
