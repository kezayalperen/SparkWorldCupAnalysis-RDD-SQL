package SparkAPP1;

import java.io.Serializable;

public class GroupPlayer implements Serializable {

    String playerName;
    int matchCount;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public GroupPlayer(String playerName, int matchCount) {
        this.playerName = playerName;
        this.matchCount = matchCount;
    }
}
