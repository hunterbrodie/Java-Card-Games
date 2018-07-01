import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.reset();
        deck.shuffle();

        ArrayList<Card> dealhand = new ArrayList<Card>();
        ArrayList<Card> playerhand = new ArrayList<Card>();

        for (int x = 0; x < 2; x++)
        {
            dealhand.add(deck.deal());
            playerhand.add(deck.deal());
        }


        int x = check(playerhand);
        int y = check(dealhand);
        if (x == 2 && y == 2)
        {
            System.out.println("Both have BlackJack, both tie");
            System.exit(0);
        }
        wincheck("Player", x, playerhand, dealhand);
        wincheck("Dealer", y, playerhand, dealhand);
        print(dealhand, playerhand, dealhand.size() - 1, playerhand.size());
        pturn(playerhand, deck, dealhand);
        dturn(dealhand, deck, playerhand);
        System.out.println();
        checkwin(playerhand, dealhand);

    }

    public static void endprint(ArrayList<Card> phand, ArrayList<Card> dhand)
    {
        System.out.println();
        System.out.println("The dealer's cards were:");
        for (int x = 0; x < dhand.size(); x++)
        {
            System.out.println(dhand.get(x).fullName());
        }
        System.out.println();
        System.out.println("Your cards were:");
        for (int x = 0; x < phand.size(); x++)
        {
            System.out.println(phand.get(x).fullName());
        }
    }

    public static void checkwin(ArrayList<Card> phand, ArrayList<Card> dhand)
    {
        if(handsize(phand) == handsize(dhand))
        {
            System.out.println("Both have same value, both tie");

            endprint(phand, dhand);
        }
        else if (handsize(phand) > handsize(dhand))
        {
            System.out.println("Player wins");

            endprint(phand, dhand);
        }
        else
        {
            System.out.println("Dealer wins");

            endprint(phand, dhand);
        }
    }

    public static void print(ArrayList<Card> dealhand, ArrayList<Card> playerhand, int upcard, int pcard)
    {
        System.out.println("The dealer's upcards are:");
        for (int x = 1; x < upcard + 1; x++)
        {
            System.out.println(dealhand.get(x).fullName());
        }

        System.out.println();
        playerprint(playerhand, pcard);
    }

    public static void playerprint(ArrayList<Card> playerhand, int pcard)
    {
        System.out.println("Your cards are:");
        for (int x = 0; x < pcard; x++)
        {
            System.out.println(playerhand.get(x).fullName());
        }
    }

    public static int check(ArrayList<Card> hand)
    {
        int y = handsize(hand);

        if(y > 21)
        {
            return 0;
        }
        else if (y == 21 && hand.size() == 2)
        {
            return 2;
        }
        else
        {
            return 1;
        }
    }

    public static int handsize(ArrayList<Card> hand)
    {
        int size = 0;
        int valcheck = 0;

        for (int x = 0; x < hand.size(); x++)
        {
            int z = hand.get(x).getValue();
            if (hand.get(x).getValue() == 1)
            {
                valcheck = 1;
            }
            else if(hand.get(x).getValue() > 10)
            {
                z = 10;
            }
            size += z;
        }

        size = valcheck(valcheck, size);

        return size;
    }

    public static int valcheck(int val, int other)
    {
        if (val == 1)
        {
            other--;
            if (other > 10)
            {
                return other + 1;
            }
            else
            {
                return other + 11;
            }
        }
        else
        {
            return other;
        }
    }

    public static ArrayList<Card> dturn(ArrayList<Card> hand, Deck deck, ArrayList<Card> phand)
    {
        boolean turn = true;
        while (turn)
        {
            int x = check(hand);
            wincheck("Dealer", x, phand ,hand);
            if (handsize(hand) < 17)
            {
                hand.add(deck.deal());
            }
            else
            {
                turn = false;
            }

        }

        return hand;
    }

    public static ArrayList<Card> pturn(ArrayList<Card> hand, Deck deck, ArrayList<Card> dhand)
    {
        Scanner scan = new Scanner(System.in);
        boolean turn = true;

        while (turn)
        {
            int x = check(hand);
            wincheck("Player", x, hand, dhand);
            System.out.println();
            System.out.println("Hit or Stay?");
            String choice = scan.nextLine();

            if (choice.toLowerCase().equals("hit"))
            {
                hand.add(deck.deal());
                playerprint(hand, hand.size());
                System.out.println();
            }
            else if (choice.toLowerCase().equals("stay"))
            {
                turn = false;
            }

        }

        return hand;
    }

    public static void wincheck(String player, int x, ArrayList<Card> phand, ArrayList<Card> dhand)
    {
        switch(x + 1)
        {
            case 1: System.out.println(player + " went bust, " + player +" Loses");
                endprint(phand, dhand);
                System.exit(0);
                break;
            case 3: System.out.println(player + " has BlackJack, " + player + " Wins");
                endprint(phand, dhand);
                System.exit(0);
        }
    }

}