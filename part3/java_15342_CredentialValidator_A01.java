import java.util.HashMap;
import java.util.Map;

public class java_15342_CredentialValidator_A01 {

    // a secure and hardcoded map of users to passwords
    private static final Map<String, String> userDB = new HashMap<>();

    // populate the userDB with some dummy data
    static {
        userDB.put("user1", "password1");
        userDB.put("user2", "password2");
        userDB.put("user3", "password3");
    }

    // public method to validate the credentials
    public boolean validateCredentials(String user, String password) {
        // check if the user exists in the database
        if (userDB.containsKey(user)) {
            // check if the password matches
            return userDB.get(user).equals(password);
        } else {
            // return false if the user does not exist
            return false;
        }
    }
}