package cardgame;
import java.util.ArrayList;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author: Munib Emre Sevilgen
// date: 19.02.2018
public class ScoreCard
{
   // properties
   private int[] scores;
   
   // constructors
   public ScoreCard( int noOfPlayers)
   {
      scores = new int[noOfPlayers];
      
      // init all scores to zero
      for ( int i = 0; i < scores.length; i++)
         scores[i] = 0;
   }
   
   // methods
   public int getScore( int playerNo)
   {
      return scores[ playerNo];
   }
   
   public void update( int playerNo, int amount)
   {
      scores[playerNo] += amount;
   }
   
   public String toString()
   {
      String s;
      s = "\n"
         + "_____________\n"
         + "\nPlayer\tScore\n"
         + "_____________\n";
      
      for ( int playerNo = 0; playerNo < scores.length; playerNo++)
      {
         s = s + playerNo + "\t" + scores[playerNo] + "\n";
      }
      
      s += "_____________\n";
      return s;
   }
   
   public int[] getWinners()
   {
      // ToDo
      int highScore;
      int tempScore;
      int[] winners;
      ArrayList<Integer> winnersList;
      winnersList = new ArrayList<Integer>();
      highScore = scores[0];
      for ( int i = 1; i < scores.length; i++) {
         tempScore = scores[i];
         if ( highScore < tempScore)
            highScore = tempScore;
      }
      for ( int i = 0; i < scores.length; i++) {
         if ( scores[i] == highScore)
            winnersList.add(i);
      }
      
      winners = new int[winnersList.size()];
      for ( int i = 0; i < winnersList.size(); i++) {
         winners[i] = winnersList.get(i);
      }
      return winners;
   }
   
} // end class ScoreCard
