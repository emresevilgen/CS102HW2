package cardgame;
import java.util.ArrayList;

// Cardgame
// author: Munib Emre Sevilgen
// date: 19.02.2018
public class CardGame
{
   // properties
   private Cards             fullPack;
   private ArrayList<Player> players;
   private ScoreCard         scoreCard;
   private Cards[]           cardsOnTable;
   private int               roundNo;
   private int               turnOfPlayer;
   
   // constructors
   public CardGame( Player p1, Player p2, Player p3, Player p4)
   {
      // ToDo
      players = new ArrayList<Player>();
      players.add(p1);
      players.add(p2);
      players.add(p3);
      players.add(p4);
      fullPack = new Cards( true);
      scoreCard = new ScoreCard( players.size());
      roundNo = 1;
      turnOfPlayer = 1;
      cardsOnTable = new Cards[(int)(fullPack.getNoOfCardsInFullPack() / players.size())];
      
   }
   
   // methods
   public void initGame() {
      int count;
      fullPack.shuffle();
      count = fullPack.getNoOfCardsInFullPack();
      while (  count > 0 ) {
         players.get( count % players.size()).add( fullPack.getTopCard());
         fullPack.removeTopCard();
         count--;
      }
   }
   public boolean playTurn( Player p, Card c)
   {
      // Todo
      if ( isGameOver())
         return false;
      if ( !isTurnOf( p))
         return false;
      
      if (turnOfPlayer % players.size() == 1) {
         cardsOnTable[roundNo - 1] = new Cards (false);
      }
      turnOfPlayer++;      
      cardsOnTable[roundNo - 1].addTopCard( c);
      if ( turnOfPlayer % players.size() == 1 )
         updateScores();
      return true;
   }
   
   private boolean isTurnOf( Player p)
   {
      // ToDo
      return players.get( getTurnOfPlayerNo() - 1).equals( p);
   }
   
   public boolean isGameOver()
   {
      // ToDo
      return ( (int) (fullPack.getNoOfCardsInFullPack() / players.size()) < roundNo);
   }
   
   public int getScore( int playerNumber)
   {
      // ToDo
      return scoreCard.getScore( playerNumber);
   }
   
   public String getName( int playerNumber)
   {
      // ToDo
      return players.get( playerNumber).getName();
   }
   
   public int getRoundNo()
   {
      // ToDo
      return roundNo;
   }
   
   public int getTurnOfPlayerNo()
   {
      // ToDo
      return turnOfPlayer;
   }
   
   private void updateScores() 
   {
      int roundWinner;
      Card[] temp;
      temp = new Card[cardsOnTable[roundNo - 1].getValid()];
      roundWinner = 0;
      for (int i = temp.length - 1; i >= 0; i--) {
         temp[i] = cardsOnTable[roundNo - 1].getTopCard();
         cardsOnTable[roundNo - 1].removeTopCard();
      }
      
      for ( int i = 0; i < temp.length; i++) {
         cardsOnTable[roundNo - 1].addTopCard(temp[i]);
         if ( temp[roundWinner].compareTo( temp[i]) == 1) 
            roundWinner = i;
      }
      scoreCard.update( roundWinner, 1);
      turnOfPlayer = 1;
      roundNo ++;
   }
   
   public Player[] getWinners()
   {
      // ToDo
      int noOfWinners;
      int[] winners;
      Player[] winnerPlayers;
      
      winners = scoreCard.getWinners();
      noOfWinners = winners.length;
      winnerPlayers = new Player[noOfWinners];
      for ( int i = 0; i < noOfWinners; i++) {
         winnerPlayers[i] = players.get( winners[i]);
      }
      return winnerPlayers;
   }
   
   public String showScoreCard()
   {
      return scoreCard.toString();
   }
   
}