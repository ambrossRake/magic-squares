package magicsquares;

public class App {

    public static void main(String[] args){
        try {
            // Creates and prints out a new Square Object of size 3.
            System.out.println(new Square(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
