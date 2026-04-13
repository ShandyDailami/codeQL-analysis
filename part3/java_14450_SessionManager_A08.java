import java.util.LinkedHashMap;

public class java_14450_SessionManager_A08 {
    private LinkedHashMap<String, String> sessionMap;

    public java_14450_SessionManager_A08() {
        sessionMap = new LinkedHashMap<>();
    }

    public String getSession(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must not be null");
        }
        return sessionMap.get(key);
    }

    public void setSession(String key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value must not be null");
        }
        sessionMap.put(key, value);
    }

    public void deleteSession(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must not be null");
        }
        sessionMap.remove(key);
    }
}