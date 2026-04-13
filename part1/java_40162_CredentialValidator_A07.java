import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_40162_CredentialValidator_A07 {
    private Map<String, String> users;

    public java_40162_CredentialValidator_A07() {
        users = new HashMap<>();
        users.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        users.put("user", Base64.getEncoder().encodeToString("user:user".getBytes()));
    }

    public String validate(String username, String password) {
        try {
            String encoded = Base64.getEncoder().encodeToString(username.concat(":").concat(password).getBytes());
            if (users.get(username).equals(encoded)) {
                return "Success";
            } else {
                throw new AuthenticationFailureException("Authentication failure");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("admin", "admin")); // Should print "Success"
        System.out.println(validator.validate("admin", "wrong_password")); // Should throw AuthenticationFailureException
        System.out.println(validator.validate("user", "user")); // Should throw AuthenticationFailureException
    }
}

class AuthenticationFailureException extends RuntimeException {
    public java_40162_CredentialValidator_A07(String message) {
        super(message);
    }
}