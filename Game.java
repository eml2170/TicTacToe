
public interface Game {

	public void initializeGame(Player[] players);
	
	/**
	 * retrieves moves from both p1 and p2 and returns the game result
	 * @return Result of one game
	 */
	public WinConfig playGame();	
	
	public void printResults();
	
	public Object returnRecord();
}
