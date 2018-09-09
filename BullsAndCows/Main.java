import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        Computer pc1 = new Computer("Pesho");
        Player player1 = new Player(num, "Tedo");
        Game game1 = new Game(player1, pc1);
        System.out.println(game1.getStatus());
    }
}
