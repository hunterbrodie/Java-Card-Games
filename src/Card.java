public class Card {


    private int value;
    private String suit;
    private String cardName;

    public Card(int Value, String Suit)
    {
        value = Value;
        suit = Suit;
        switch(value)
        {
            case 1: cardName = "Ace";
                break;
            case 11: cardName = "Jack";
                break;
            case 12: cardName = "Queen";
                break;
            case 13: cardName = "King";
                break;
            default: cardName = value + "";
        }
    }

    public int getValue()
    {
        return value;
    }
    public void setValue(int v)
    {
        value = v;
        switch(value)
        {
            case 1: cardName = "Ace";
                break;
            case 11: cardName = "Jack";
                break;
            case 12: cardName = "Queen";
                break;
            case 13: cardName = "King";
                break;
            default: cardName = value + "";
        }
    }
    public String getSuit()
    {
        return suit;
    }
    public void setSuit(String s)
    {
        suit = s;
    }
    public String getName()
    {
        return cardName;
    }
    public String fullName()
    {
        return cardName + " of " + suit;
    }
}
