import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Talker class communicates with the console and receives input
 * Easily could be upgraded to a GUI interface as well
 */
public class Talker {
	
    private static BufferedReader reader;
            
    
	public Talker() {
		reader = new BufferedReader(new InputStreamReader(System.in)) ;
	}
	
    protected String getUserInput() {
        String input = "" ;
        try {
            input = reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return input ;
    }
    
    public String getPosDescription(int pos) {
        String str = "";
        if( pos == 5 ) {
            str = "center" ;
            return str ;
        }

        if( (pos-1)/3 == 0 ) {
            str += "upper " ;
        }
        else if( (pos-1)/3 == 1 ) {
            str += "middle " ;
        }
        else
            str += "lower " ;

        if( (pos-1) % 3 == 0 )
            str += "left" ;
        else if( (pos-1)%3 == 1 )
            str += "middle" ;
        else
            str += "right" ;

        return str ;
    }
   
	
	public void greetPlayer() {
		System.out.println("Welcome to Tic-Tac-Toe.");
		System.out.println("");	
	}
	
	public void promptName(){
		System.out.println("Enter player name");
	}

	public void promptMove(){
		System.out.print("Where to ? ");
	}
	
	public void presentPlayers(String player1, String player2){
      System.out.println("\nHuman player " + player1 + " vs Computer Player " + player2 + ":" ) ;
	}
	
	public void instructPlayer(Game g){
		System.out.println("Please make your move selection by entering a number 1-9 corresponding to the movement key on the right.\n");
		System.out.println(g);
	}
	
	public void stateMoves(int move1, int move2){
		System.out.println("");
		System.out.println("You have put an X in the " + getPosDescription(move1) + ". I will put a O in the " + getPosDescription(move2) + "." ) ;
	}
}
