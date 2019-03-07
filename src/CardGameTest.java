import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author: Munib Emre Sevilgen
// date: 19.02.2018
public class CardGameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of CardGameTest\n");
        
        // CONSTANTS
        
        // VARIABLES
        Card       c;
        Cards      cards;
        ScoreCard  scores;
        Player     p;
        Player     p1;
        Player     p2;
        Player     p3;
        Player     p4;
        CardGame   game;
        
        // PROGRAM CODE
        
        // test Card class
        c = new Card( 1);
        System.out.println( c);
        System.out.println();
        
        // test Cards class
        cards = new Cards( false);
        System.out.println( cards.addTopCard( c));
        cards = new Cards( true);
        // cards.testOnlyPrint();  // remove method after testing!
        System.out.println();
        cards.shuffle();
        // cards.testOnlyPrint();
        
        // test ScoreCard class
        scores = new ScoreCard( 4);
        scores.update( 3, 1);
        scores.update( 1, 2);
        System.out.println( "\n" + scores );
        
        // test Player class
        // ToDo
        p = new Player("p");
        p.add(c);
        System.out.println( "Name: " + p.getName());
        System.out.println( p.playCard());
        
        // test CardGame class too?
        // Todo
        p1 = new Player("p1");
        p2 = new Player("p2");
        p3 = new Player("p3");
        p4 = new Player("p4");
        game = new CardGame( p1, p2, p3, p4);
        game.initGame();
        System.out.println(  game.playTurn(p1, p1.playCard()));
        System.out.println(  game.playTurn(p2, p2.playCard()));
        System.out.println(  game.playTurn(p2, p2.playCard()));
        System.out.println(  game.playTurn(p3, p3.playCard()));
        
        
        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.
        
        System.out.println( "\nEnd of CardGameTest\n" );
    }
    
} // end of class CardGameTest
