import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_14955_CredentialValidator_A03 {
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    private static final Map<String, String> VALID_USERS = new HashMap<>();
    private static final Map<String, String> VALID_PASSWORDS = new HashMap<>();

    static {
        VALID_USERS.put("user1", Base64.getEncoder().encodeToString("user1:user1".getBytes()));
        VALID_PASSWORDS.put("user1", "$2a$10$./.././../../.././.user1");
    }

    public static class Credentials {
        private String username;
        private String password;

        public java_14955_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class CredentialValidator {
        public boolean validate(Credentials credentials) {
            String encodedUsername = Base64.getEncoder().encodeToString(credentials.getUsername().getBytes());
            String encodedPassword = Base64.getEncoder().encodeToString(credentials.getPassword().getBytes());

            return VALID_USERS.containsKey(encodedUsername) &&
                    VALID_PASSWORDS.containsKey(encodedPassword) &&
                    VALID_USERS.get(encodedUsername).equals(encodedUsername) &&
                    VALID_PASSWORDS.get(encodedPassword).equals(encodedPassword);
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        Credentials credentials = new Credentials("user1", "user1");
        boolean valid = validator.validate(credentials);

        System.out.println("Credentials are valid: " + valid);
    }
}