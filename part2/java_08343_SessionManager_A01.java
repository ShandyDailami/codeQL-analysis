import java.util.concurrent.ConcurrentHashMap;

public class java_08343_SessionManager_A01 {
    private ConcurrentHashMap<String, String> usernamePasswordMap;

    public java_08343_SessionManager_A01() {
        this.usernamePasswordMap = new ConcurrentHashMap<>();
    }

    public void addUser(String username, String password) {
        usernamePasswordMap.put(username, password);
    }

    public String getUser(String username) {
        return usernamePasswordMap.get(username);
    }

    public boolean isValidUser(String username, String password) {
        return usernamePasswordMap.get(username) != null && usernamePasswordMap.get(username).equals(password);
    }
}