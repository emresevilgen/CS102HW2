package cardgame;

// Player - Simple card game player with name and hand of cards
// author: Munib Emre Sevilgen
// date: 19.02.2018
public class Player
{
   // properties
   private String name;
   private Cards  hand;
   
   // constructors
   public Player( String name)
   {
      // ToDo
      this.name = name;
      hand = new Cards( false);
   }
   
   // methods
   public String getName()
   {
      return name;
   }
   
   public void add( Card c)
   {
      hand.addTopCard( c);
   }
   
   public Card playCard()
   {
      // ToDo
      Card temp;
      temp = hand.getTopCard();
      hand.removeTopCard();
      return temp;
   }
   
} // end class Player
