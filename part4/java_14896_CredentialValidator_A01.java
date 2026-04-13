import java.util.HashMap;
import java.util.Map;

public class java_14896_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_14896_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean validate(String username, String password) {
        return this.credentials.containsKey(username) && 
               this.credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addCredential("admin", "password");

        System.out.println(validator.validate("admin", "password"));  // Output: true
        System.out.println(validator.validate("admin", "wrongPassword"));  // Output: false
        System.out.println(validator.validate("user", "password"));  // Output: false
    }
}