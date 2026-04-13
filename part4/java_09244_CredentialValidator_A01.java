import java.util.HashMap;
import java.util.Map;

public class java_09244_CredentialValidator_A01 {
    private Map<String, String> userDatabase;

    public java_09244_CredentialValidator_A01() {
        userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        userDatabase.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            System.out.println("Credentials validated successfully!");
            return true;
        } else {
            System.out.println("Credentials are incorrect!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials("user1", "password1");
        validator.validateCredentials("user2", "wrongpassword");
        validator.validateCredentials("wronguser", "wrongpassword");
    }
}