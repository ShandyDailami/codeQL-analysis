import java.util.HashMap;
import java.util.Map;

public class java_29514_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_29514_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean isValidCredential(String username, String password) {
        return this.credentials.containsKey(username)
                && this.credentials.get(username).equals(password);
    }
}

public class InjectionDemo {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addCredential("admin", "password");

        boolean isValid = validator.isValidCredential("admin", "password");
        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}