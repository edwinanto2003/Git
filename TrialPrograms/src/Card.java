
public class Card 
{
    public enum Suit
    {
        CLUBS, SPADES, HEARTS, DIAMONDS; 
    }

    public enum Value
    {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ACE, King, Queen, Jack;
    }
    
    private Value value;
    private Suit suit;

    public Card(Value val, Suit suit)
    {
        this.value = val;
        this.suit = suit;
    }

    public Value getValue() 
    {
        return value;
    }

    public Suit getSuit() 
    {
        return suit;
    }


    public static void main(String[] args)
    {
        Card card = new Card(Value.King, Suit.CLUBS);

        System.out.println(card.getValue() + " of " + card.getSuit());
    }
}
