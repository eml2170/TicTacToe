import java.util.ArrayList;


public class TicTacToe implements Game
{
	protected static final int N = 3 ;
	private static final int HSPACE = 20 ;
	protected int[][] board;
	protected ArrayList<Integer>[] moves;

	private Player player1,player2;


	public TicTacToe()
	{
		board = new int[N][N];
		for( int i = 0 ; i < N ; i ++ ) {
			for( int j = 0 ; j < N ; j ++ ) {
				board[i][j] = 0 ;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void initializeGame(Player[] players){
		player1 = players[0];
		player2 = players[1];
		moves = new ArrayList[2];
		moves[0] = new ArrayList<Integer>();
		moves[1] = new ArrayList<Integer>();
	}

	public WinConfig playGame(){
		//game might be in an end state, particularly in the case of a draw
		if(isWinningConfig() != WinConfig.NONE)
			return isWinningConfig();

		int move1, move2;
		do {
			move1 = player1.getMove();
		} while(!setMove(move1,player1.getPlayerType() )); //while move is invalid

		//player 1 could have ended the game
		if(isWinningConfig() != WinConfig.NONE)
			return isWinningConfig();

		move2 = player2.getMove();

		setMove(move2, player2.getPlayerType() ) ;
		System.out.println(this); //TODO move this
		return WinConfig.NONE;
	}

	public void printResults(){
		if( ( isWinningConfig() ) == WinConfig.P1WIN ) {
			System.out.println("");
			System.out.println(this);
			System.out.println("Player one wins!");
		}
		else if(isWinningConfig() == WinConfig.DRAW ) {
			System.out.println("");
			System.out.println(this) ;
			System.out.println("Well played. It is a draw!");
		}
		else if( isWinningConfig() == WinConfig.P2WIN ) {
			System.out.println("");
			System.out.println(this);
			System.out.println("I won. Thanks for playing.") ;
		}
	}

	/**
	 * @param move index
	 * @param p_type player type
	 * @return whether the move is valid
	 */
	public boolean setMove(int move, int p_type)
	{
		int x_coord = (move-1)/3;
		int y_coord = (move-1)%3;

		if( board[x_coord][y_coord] == 0 )
		{
			board[x_coord][y_coord] = p_type ;
			moves[p_type-1].add(move);
			return true ;
		}
		else
		{
			System.out.println("Invalid move");
			return false ;
		}
	}

	protected WinConfig isWinningConfig()
	{
		WinConfig w;
		// rows
		for( int i = 0 ; i < N ; i ++ )
		{
			if( (board[i][0] != 0) && (board[i][0] == board[i][1]) && (board[i][0] == board[i][2] ) )
			{
				return board[i][0] == 1 ? WinConfig.P1WIN : WinConfig.P2WIN;
			}
		}
		// columns
		for( int i = 0 ; i < N ; i ++ )
		{
			if( (board[0][i] != 0) && (board[0][i] == board[1][i]) && (board[0][i] == board[2][i] ) )
			{
				return board[0][i] == 1 ? WinConfig.P1WIN : WinConfig.P2WIN;
			}
		}
		// diags
		if( (board[0][0] != 0) && (board[0][0] == board[1][1]) && (board[0][0] == board[2][2] ) )
		{
			return board[0][0] == 1 ? WinConfig.P1WIN : WinConfig.P2WIN;
		}

		if( (board[2][0] != 0) && (board[2][0] == board[1][1]) && (board[2][0] == board[0][2] ) )
		{
			return board[2][0] == 1 ? WinConfig.P1WIN : WinConfig.P2WIN;
		}

		// draw
		w = WinConfig.DRAW ;
		for( int i = 0 ; i < N ; i ++ )
			for( int j = 0 ; j < N ; j ++ )
			{
				if( board[i][j] == 0 )
					w = WinConfig.NONE ;
			}
		return w ;

	}

	public Object returnRecord(){
		return moves;
	}

	private String getRowString(int row)
	{
		String s = "" ;
		for( int i = 0 ; i < N ; i ++ )
		{
			switch(board[row][i]) {
			case 0: s += " " ;
			break ;
			case 1: s += "X" ;
			break ;
			case 2: s += "O" ;
			}

			if( i != N-1 )
			{
				s += " | " ;
			}
		}

		s += String.format("%" + HSPACE + "s", "");

		for( int i = 0 ; i < N ; i ++ )
		{
			s += row*3+i+1 ;

			if( i == N-1 ) {
				s += "\n";
			}
			else {
				s += " | " ;
			}
		}
		return s;
	}

	public String toString()
	{
		String s = "";
		// iterate through the rows
		for( int i = 0 ; i < N ; i ++ ) {
			s += getRowString(i);
		}
		return s;
	}
}


