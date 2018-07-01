import java.util.Random;
import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck()
    {
        cards = new ArrayList<Card>();
    }

    public void reset()
    {
        String suitName = "";
        for (int x = 1; x <= 4; x++)
        {
            switch (x)
            {
                case 1: suitName = "Hearts";
                    break;
                case 2: suitName = "Diamonds";
                    break;
                case 3: suitName = "Clubs";
                    break;
                case 4: suitName = "Spades";
            }
            for (int y = 1; y < 14; y++)
            {
                Card card = new Card(y, suitName);
                cards.add(card);
            }
        }
    }

    public String get(int x)
    {
        Card card = new Card(x, "Spades");
        card = cards.get(x);
        return card.fullName();
    }

    public void shuffle()
    {
        Random rand = new Random();

        Card phold;

        for (int x = 0; x < 52; x++)
        {
            int x1 = rand.nextInt(52);
            int x2 = rand.nextInt(52);

            phold = cards.get(x1);
            cards.set(x1, cards.get(x2));
            cards.set(x2, phold);
        }
    }

    public Card deal()
    {
        Card card = new Card(0, "");

        card = cards.get(0);
        cards.remove(0);

        return card;
    }
}
