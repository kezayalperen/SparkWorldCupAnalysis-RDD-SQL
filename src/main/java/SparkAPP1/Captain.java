package SparkAPP1;

public class Captain {

    String playerName;
    int captainCount;

    public Captain(String playerName, int captainCount) {
        this.playerName = playerName;
        this.captainCount = captainCount;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCaptainCount() {
        return captainCount;
    }

    public void setCaptainCount(int captainCount) {
        this.captainCount = captainCount;
    }
}
