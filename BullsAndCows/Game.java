public class Game {
    private Computer computer;
    private Player player;
    private String playerNumber;
    private String computerNumber;
    private int bulls = 0;
    private int cows = 0;

    Game(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
        this.playerNumber = this.player.getNumber();
        this.computerNumber = this.computer.getNumber();
    }

    private void getCowsAndBulls() {
        this.bulls = 0;
        this.cows = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.computerNumber.charAt(i) == this.playerNumber.charAt(j) && i != j) {
                    this.cows++;
                }
                if (this.computerNumber.charAt(i) == this.playerNumber.charAt(j) && i == j) {
                    this.bulls++;
                }

            }
        }
    }


    public String getStatus() {
        getCowsAndBulls();
        String str;
        if (this.bulls == 4) {
            str = "Печелиш";
            return str;
        } else {
            str = "Bulls: " + this.bulls + " Cows: " + this.cows + " ";
            return str;
        }
    }
}
