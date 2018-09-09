//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Game {
    private Computer computer;
    private Player player;
    private String playerNumber;
    private String computerNumber;
    private int bulls = 0;
    private int cows = 0;

    Game(Player player, Computer computer) {
        this.player = new Player(player.getNumber(), player.getPlayerName());
        this.computer = new Computer(computer.getComputerName());
        this.playerNumber = this.player.getNumber();
        this.computerNumber = this.computer.getNumber();
    }

    private int getBulls() {
        for (int i = 0; i < 4; ++i) {
            if (this.playerNumber.charAt(i) == this.computerNumber.charAt(i)) {
                ++this.bulls;
            }
        }

        return this.bulls;
    }

    private int getCows() {
        for (int i = 0; i < 4; ++i) {
            if (this.playerNumber.charAt(i) != this.computerNumber.charAt(i)) {
                ++this.cows;
            }
        }

        return this.cows;
    }

    public String getStatus() {
        String str;
        if (this.getBulls() == 4) {
            str = "Печелиш";
            return str;
        } else {
            str = "Bulls: " + this.getBulls() + " Cows: " + this.getCows() + " ";
            return str;
        }
    }
}
