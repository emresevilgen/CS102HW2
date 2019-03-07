package cardgame;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author: Munib Emre Sevilgen
// date: 19.02.2018
public class Cards
{
   private final int NOOFCARDSINFULLPACK = 52;
   
   // properties
   private Card[] cards;
   private int    valid;  // number of cards currently in collection
   
   // constructors
   public Cards( boolean fullPack)
   {
      cards = new Card[ NOOFCARDSINFULLPACK ];
      valid = 0;
      
      if ( fullPack)
         createFullPackOfCards();
   }
   
   // methods
   public Card getTopCard()
   {
      if ( valid > 0) {
         return cards[valid - 1];
      }
      
      return null;
   }
   
   public boolean addTopCard( Card c)
   {
      if ( valid < cards.length)
      {
         cards[valid] = c;   // should this be cloned?
         valid++;
         return true;
      }
      return false;
   }
   
   public boolean removeTopCard()
   {
      if ( valid > 0) {
         cards[valid - 1] = null;
         valid--;
         return true;
      }
      return false;
   }
   
   
   private void createFullPackOfCards()
   {
      // Todo
      for ( int i = 0; i < NOOFCARDSINFULLPACK; i++)
         addTopCard( new Card(i) );
   }
   
   public void shuffle()
   {
      // Todo
      Card tempCard;
      int random;
      
      for ( int i = 0; i < valid; i++) {
         random = (int)(Math.random() * valid);
         tempCard = cards[random];
         cards[random] = cards[i];
         cards[i] = tempCard;
      }
   }
   
   public int getValid() {
      return valid;
   }
   
   public int getNoOfCardsInFullPack() {
      return NOOFCARDSINFULLPACK;
   }
   
//   // For testOnly... remove from production version!
//   public void testOnlyPrint()
//   {
//      for ( int i =0; i < valid; i++)
//      {
//         System.out.println( cards[i] );
//      }
//   }
   
} // end class Cards
