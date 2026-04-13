import java.util.HashMap;
import java.util.Map;

public class java_30630_CredentialValidator_A03 {

    private Map<String, String> users = new HashMap<>();

    public java_30630_CredentialValidator_A03() {
        users.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        return users.get(username).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validate("admin", "password");
        System.out.println("Is valid: " + isValid);
    }
}