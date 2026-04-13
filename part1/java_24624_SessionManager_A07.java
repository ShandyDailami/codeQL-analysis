import java.util.HashMap;
import java.util.Map;

public class java_24624_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_24624_SessionManager_A07() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    public String validateUser(String user, String password) {
        String hashedPassword = userMap.get(user);

        if (hashedPassword == null || !hashedPassword.equals(hashPassword(password))) {
            throw new AuthFailureException();
        }

        return "User is authenticated.";
    }

    private String hashPassword(String password) {
        // This is a placeholder implementation. In a real-world application, passwords should be hashed using a strong hashing algorithm.
        return password;
    }
}