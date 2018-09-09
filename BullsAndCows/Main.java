import java.util.Scanner;

public class Main {
    public static void startInsertingNumbers(Scanner in) {
        Computer pc1 = new Computer("Pesho");
        Player player1;
        Game game1;

        String num;
        while (true) {
            num = in.next();

            if (num.toLowerCase().equals("end")) {
                break;
            }
            player1 = new Player(num, "Tedo");
            game1 = new Game(player1, pc1);
            System.out.println(pc1.number);
            System.out.println(game1.getStatus());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);



        startInsertingNumbers(in);


    }
}
