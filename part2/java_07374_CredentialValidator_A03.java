import java.util.HashMap;

public class java_07374_CredentialValidator_A03 {
    private HashMap<String, String> credentials;

    public java_07374_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validateCredentials("admin", "password");

        if (isValid) {
            System.out.println("Valid credentials!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}