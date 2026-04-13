import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_19605_CredentialValidator_A01 {

    // HashMap to hold user names and passwords
    private Map<String, String> userMap;

    // Constructor
    public java_19605_CredentialValidator_A01() {
        userMap = new HashMap<String, String>();
        // Initialize userMap with dummy data
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    // Method to authenticate the user
    public boolean authenticate(String userName, String password) {
        // Decode the password
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordStr = new String(decodedPassword);

        // Validate the user and password
        if (userMap.containsKey(userName) && userMap.get(userName).equals(decodedPasswordStr)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Authenticate user1
        String user1Password = "ZW5jb2RlZCB0ZXh0"; // Base64 of "password1"
        if (validator.authenticate("user1", user1Password)) {
            System.out.println("Access granted to user1");
        } else {
            System.out.println("Access denied to user1");
        }

        // Authenticate user2
        String user2Password = "ZW5jb2RlZCB0ZXh0"; // Base64 of "password2"
        if (validator.authenticate("user2", user2Password)) {
            System.out.println("Access granted to user2");
        } else {
            System.out.println("Access denied to user2");
        }
    }
}