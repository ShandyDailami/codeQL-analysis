import java.util.HashMap;
import java.util.Map;

public class java_08570_CredentialValidator_A01 {

    // Define a HashMap to store user credentials. This is a bad practice,
    // but for the purpose of this example, we are only using it for simplicity.
    private static Map<String, String> userCredentials = new HashMap<>();

    static {
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    public static boolean validateCredentials(String username, String password) {
        // Check if the given username and password match those in our map.
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }
}