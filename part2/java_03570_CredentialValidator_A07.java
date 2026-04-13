import java.util.HashMap;
import java.util.Map;

public class java_03570_CredentialValidator_A07 {

    // Hard-coded credentials
    private static final Map<String, String> USER_PASSWORD_MAP = new HashMap<>();

    static {
        USER_PASSWORD_MAP.put("user1", "password1");
        USER_PASSWORD_MAP.put("user2", "password2");
        USER_PASSWORD_MAP.put("user3", "password3");
        // add more users as needed
    }

    public boolean validate(String username, String password) {
        // check if the username and password are in the map
        // if they are, return true, else return false
        return USER_PASSWORD_MAP.containsKey(username)
                && USER_PASSWORD_MAP.get(username).equals(password);
    }

}