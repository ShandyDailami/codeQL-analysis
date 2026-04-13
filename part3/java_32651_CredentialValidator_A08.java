import java.util.HashMap;
import java.util.Map;

public class java_32651_CredentialValidator_A08 {

    private Map<String, String> userDatabase;

    public java_32651_CredentialValidator_A08() {
        userDatabase = new HashMap<>();
        userDatabase.put("admin", "password");
    }

    public boolean validate(String user, String password) {
        return userDatabase.containsKey(user) && userDatabase.get(user).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean result = validator.validate("admin", "password");
        System.out.println("Credentials valid: " + result);
    }
}