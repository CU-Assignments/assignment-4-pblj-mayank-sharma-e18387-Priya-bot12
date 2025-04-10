import java.util.*;

class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    public void displayCard() {
        System.out.println("Card: " + value + " of " + symbol);
    }
}

public class CardCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList<Card>> cardMap = new HashMap<>();

        System.out.print("Enter the number of cards to add: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter card " + (i + 1) + " symbol: ");
            String symbol = sc.nextLine();
            System.out.print("Enter card " + (i + 1) + " value: ");
            String value = sc.nextLine();

            Card card = new Card(symbol, value);
            cardMap.computeIfAbsent(symbol, k -> new ArrayList<>()).add(card);
        }

        System.out.print("\nEnter a symbol to search (e.g., Hearts, Spades): ");
        String searchSymbol = sc.nextLine();

        if (cardMap.containsKey(searchSymbol)) {
            ArrayList<Card> cards = cardMap.get(searchSymbol);
            System.out.println("\nCards of symbol '" + searchSymbol + "':");
            for (Card c : cards) {
                c.displayCard();
            }
        } else {
            System.out.println("No cards found for symbol: " + searchSymbol);
        }

        sc.close();
    }
}
