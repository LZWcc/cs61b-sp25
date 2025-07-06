public class Dessert {
    public int flavor, price;
    public static int numDessert = 0;

    public Dessert(int f, int p) {
        flavor = f;
        price = p;
        numDessert++;
    }

    public void printDessert() {
        System.out.println(flavor + " " + price + " " +  numDessert);
    }

    public static void main(String[] args) {
        System.out.println("I love dessert!");
    }
}
