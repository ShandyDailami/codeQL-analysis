import java.util.Base64;
import java.util.HashMap;

public class java_24484_CredentialValidator_A07 {
    // Map to store user credentials
    private HashMap<String, String> userCredentials;

    // Constructor
    public java_24484_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
    }

    // Method to add user credentials
    public void addUser(String username, String password) {
        userCredentials.put(username, password);
    }

    // Method to validate user credentials
    public boolean validateUser(String username, String password) {
        if(userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator cv = new CredentialValidator();
        cv.addUser("alice", "password1");
        cv.addUser("bob", "password2");

        System.out.println(cv.validateUser("alice", "password1")); // Expected output: true
        System.out.println(cv.validateUser("bob", "password2")); // Expected output: true
        System.out.println(cv.validateUser("alice", "wrongpassword")); // Expected output: false
        System.out.println(cv.validateUser("bob", "wrongpassword")); // Expected output: false
    }
}