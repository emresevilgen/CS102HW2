package cardgame;

/**
 * Card - a single playing card
 * @author Munib Emre Sevilgen
 * @version 1.00 19.02.2018
 */
public class Card
{
   private final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs"};
   private final String[] FACES = { "A", "2", "3", "4", "5",
      "6", "7", "8", "9", "10",
      "J", "Q", "K"};
   
   private final int NOOFCARDSINSUIT = 13;
   
   // properties
   private int  cardNo;
   
   // constructors
   public Card( int faceValue, int suit )
   {
      cardNo = faceValue + suit * NOOFCARDSINSUIT;
   }
   
   public Card( int cardNumber)
   {
      cardNo = cardNumber;
   }
   
   public int getFaceValue()
   {
      return cardNo % NOOFCARDSINSUIT;
   }
   
   public int getSuit()
   {
      return cardNo / NOOFCARDSINSUIT;
   }
   
   public String toString()
   {
      return FACES[ getFaceValue() ] + " of " + SUITS[ getSuit() ];
   }
   
   public boolean equals( Card c)
   {
      // ToDo 
      return (cardNo == c.cardNo);
   }
   
   public int compareTo( Card c)
   {
      // ToDo    
      if ( c.cardNo > cardNo)
         return 1;
      else if ( c.cardNo == cardNo)
         return 0;
      else
         return -1;
   }
}