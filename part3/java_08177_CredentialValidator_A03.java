import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_08177_CredentialValidator_A03 {

    private Map<String, String> userData;

    public java_08177_CredentialValidator_A03() {
        this.userData = new HashMap<>();
    }

    public void addUser(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        userData.put(username, encodedPassword);
    }

    public boolean validateCredentials(String username, String password) {
        if (!userData.containsKey(username)) {
            System.out.println("Invalid username");
            return false;
        }

        String expectedPassword = userData.get(username);
        String encodedProvidedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        if (!encodedPassword.equals(encodedProvidedPassword)) {
            System.out.println("Invalid password");
            return false;
        }

        System.out.println("Access granted for user: " + username);
        return true;
    }
}