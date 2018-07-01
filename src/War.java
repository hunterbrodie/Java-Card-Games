import java.util.ArrayList;

public class War {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.reset();
        deck.shuffle();

        ArrayList<Card> c1 = new ArrayList<Card>();
        ArrayList<Card> c2 = new ArrayList<Card>();

        Card buffer= new Card(0, "buffer");
        c1.add(buffer);
        c2.add(buffer);

        for (int x = 1; x < 27; x++)
        {
            c1.add(deck.deal());
            c2.add(deck.deal());
        }

        turn(c1, c2);

    }

    public static int value(ArrayList<Card> c1, ArrayList<Card> c2)
    {
        if(c1.get(1).getValue() > c2.get(1).getValue())
        {
            return 1;
        }
        else if(c1.get(1).getValue() < c2.get(1).getValue())
        {
            return 2;
        }
        else
        {
            return 3;
        }
    }

    public static void turn(ArrayList<Card> c1, ArrayList<Card> c2)
    {
        boolean turn = true;

        while(turn)
        {
            int value = value(c1, c2);

            switch(value)
            {
                case 1:
                    c1.add(c1.get(1));
                    c1.add(c2.get(1));
                    c1.remove(1);
                    c2.remove(1);
                    break;
                case 2:
                    c2.add(c1.get(1));
                    c2.add(c2.get(1));
                    c1.remove(1);
                    c2.remove(1);
                    break;
                case 3:
                    int value1 = value(c1, c2);

                    switch(value1)
                    {
                        case 1:
                            c1.add(c1.get(1));
                            c1.add(c2.get(1));
                            c1.remove(1);
                            c2.remove(1);
                            break;
                        case 2:
                            c2.add(c1.get(1));
                            c2.add(c2.get(1));
                            c1.remove(1);
                            c2.remove(1);
                    }

                    for (int x = 0; x < 4; x ++)
                    {
                        c1.add(c1.get(1));
                        c1.add(c2.get(1));
                        c1.remove(1);
                        c2.remove(1);
                    }
            }

            if (c1.size() == 1)
            {
                System.out.println("Computer 2 Wins");
                turn = false;
            }
            else if (c2.size() == 1)
            {
                System.out.println("Computer 1 Wins");
                turn = false;
            }

        }

    }

}