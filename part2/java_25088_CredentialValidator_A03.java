import java.util.HashMap;
import java.util.Map;

public class java_25088_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_25088_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validate(String user, String password) {
        return this.credentials.containsKey(user) && this.credentials.get(user).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("user1", "password1")); // True
        System.out.println(validator.validate("user2", "wrongpassword")); // False
        System.out.println(validator.validate("user4", "password4")); // False
    }
}