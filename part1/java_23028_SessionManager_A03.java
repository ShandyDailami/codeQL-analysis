import java.util.HashMap;

public class java_23028_SessionManager_A03 {
    private HashMap<String, String> sessionMap;
    private static final String[] DISALLOWED_IDS = {"001", "002", "003"};

    public java_23028_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String id) {
        // Check for disallowed IDs
        for (String disallowedId : DISALLOWED_IDS) {
            if (id.equals(disallowedId)) {
                System.out.println("Disallowed ID: " + id);
                return null;
            }
        }

        sessionMap.put(id, "Session Data");
        return id;
    }

    public String getSession(String id) {
        // Check for disallowed IDs
        for (String disallowedId : DISALLOWED_IDS) {
            if (id.equals(disallowedId)) {
                System.out.println("Disallowed ID: " + id);
                return null;
            }
        }

        return sessionMap.get(id);
    }

    public void deleteSession(String id) {
        // Check for disallowed IDs
        for (String disallowedId : DISALLOWED_IDS) {
            if (id.equals(disallowedId)) {
                System.out.println("Disallowed ID: " + id);
                return;
            }
        }

        sessionMap.remove(id);
    }
}