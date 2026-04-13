import java.util.HashMap;
import java.util.Map;

public class java_02487_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_02487_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean validateCredential(String username, String password) {
        if (!this.credentials.containsKey(username)) {
            System.out.println("Invalid username");
            return false;
        } else if (!this.credentials.get(username).equals(password)) {
            System.out.println("Invalid password");
            return false;
        } else {
            System.out.println("Validated successfully");
            return true;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addCredential("user1", "password1");
        validator.addCredential("user2", "password2");

        validator.validateCredential("user1", "password1"); // valid credentials
        validator.validateCredential("user1", "wrong_password"); // invalid password
        validator.validateCredential("wrong_user", "password"); // invalid username
    }
}