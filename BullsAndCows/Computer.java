public class Computer {
    private String number;
    private String computerName;

    Computer(String computerName) {
        this.computerName = computerName;
        this.number = this.getComputerName();
    }

    public String getNumber() {
        return this.number;
    }

    public String getComputerName() {
        return this.computerName;
    }

    private void generateNumber() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 4; ++i) {
            String rand = Integer.toString((int)(Math.random() * 10.0D));
            if (sb.indexOf(rand) == -1) {
                sb.append(rand);
            } else {
                --i;
            }
        }

        this.number = sb.toString();
    }
}
