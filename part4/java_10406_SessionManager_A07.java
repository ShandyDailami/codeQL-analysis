import java.util.HashMap;
import java.util.Map;

public class java_10406_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_10406_SessionManager_A07() {
        userMap = new HashMap<>();
        userMap.put("alice", "password1");
        userMap.put("bob", "password2");
    }

    public String authenticate(String user, String password) {
        if (!userMap.containsKey(user) || !userMap.get(user).equals(password)) {
            return "A07_AuthFailure";
        }
        return "A07_AuthSuccess";
    }
}