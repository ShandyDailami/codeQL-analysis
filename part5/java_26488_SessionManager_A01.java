import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_26488_SessionManager_A01 {
    private Map<String, String> sessionMap;
    private String passwordFilePath;

    public java_26488_SessionManager_A01(String passwordFilePath) {
        this.passwordFilePath = passwordFilePath;
        this.sessionMap = new HashMap<>();
        readPasswordFile();
    }

    private void readPasswordFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(passwordFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] pair = line.split(":");
                sessionMap.put(pair[0], pair[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSessionId(String username, String password) {
        if (sessionMap.containsKey(username) && sessionMap.get(username).equals(password)) {
            return username;
        }
        return null;
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}