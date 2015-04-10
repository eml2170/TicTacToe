import java.util.ArrayList;


public class TicTacToeRunner {

	public static void main(String[] args) {
		{

			Game game = new TicTacToe();	

			Talker t = new Talker();

			t.greetPlayer();
			t.promptName();

			Player player1 = new Player(t.getUserInput(),1,new HumanMove(t));
			Player player2 = new Player("",2,new SimpleMoveStrategy((TicTacToe) game));

			t.presentPlayers(player1.getName(), player2.getName());

			game.initializeGame(new Player[]{player1,player2});

			t.instructPlayer(game);
			while(true) {
				WinConfig result = game.playGame();

				if(result != WinConfig.NONE) {
					game.printResults();
					break;
				}
				else{
					ArrayList<Integer>[] moves = (ArrayList<Integer>[]) game.returnRecord();
					int move1 = moves[0].get(moves[0].size()-1);
					int move2 = moves[1].get(moves[1].size()-1);
					t.stateMoves(move1, move2);
				}
			}


		}
	}

}
