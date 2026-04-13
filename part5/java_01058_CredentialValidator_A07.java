import java.util.HashMap;
import java.util.Map;

public class java_01058_CredentialValidator_A07 {
    // Static map to hold users and their passwords.
    private static Map<String, String> userPasswordMap = new HashMap<>();

    static {
        userPasswordMap.put("user1", "password1");
        userPasswordMap.put("user2", "password2");
        userPasswordMap.put("user3", "password3");
    }

    public boolean validate(String user, String password) {
        // Check if the user exists in the map.
        if (!userPasswordMap.containsKey(user)) {
            System.out.println("Invalid user!");
            return false;
        }

        // Check if the password matches the expected password.
        if (!userPasswordMap.get(user).equals(password)) {
            System.out.println("Invalid password!");
            return false;
        }

        return true;
    }
}