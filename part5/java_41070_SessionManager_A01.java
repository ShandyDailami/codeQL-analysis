public class java_41070_SessionManager_A01 {
    private Player player;

    public java_41070_SessionManager_A01(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

public class Player {
    private String name;

    public java_41070_SessionManager_A01(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class SecurityManager {
    private GameSession gameSession;

    public java_41070_SessionManager_A01(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    public GameSession getGameSession() {
        return gameSession;
    }

    public void setGameSession(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    public Player getPlayerFromSession() {
        return this.gameSession.getPlayer();
    }

    public void startSession(Player player) {
        this.gameSession = new GameSession(player);
    }
}