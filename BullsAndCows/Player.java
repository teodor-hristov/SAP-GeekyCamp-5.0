public class Player {
    private String number;
    private String playerName;

    Player(String number, String playerName) {
        this.number = number;
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
