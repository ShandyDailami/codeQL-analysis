import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64.Decoder;

public class java_20957_CredentialValidator_A03 {

    private static final String SALT = "salt"; // a secret key used for hashing
    private Map<String, String> credentials = new HashMap<>();

    public java_20957_CredentialValidator_A03() {
        // add some dummy credentials
        credentials.put("user1", hashPassword("password1", SALT));
        credentials.put("user2", hashPassword("password2", SALT));
    }

    public boolean validate(String user, String password) {
        String hashedPassword = credentials.get(user);
        if (hashedPassword != null) {
            return hashedPassword.equals(hashPassword(password, SALT));
        } else {
            return false;
        }
    }

    private String hashPassword(String password, String salt) {
        return Base64.getEncoder().encodeToString((salt + password).getBytes());
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean valid = validator.validate("user1", "password1");
        System.out.println("User 1 is valid: " + valid);
        valid = validator.validate("user2", "wrongpassword");
        System.out.println("User 2 is valid: " + valid);
    }
}