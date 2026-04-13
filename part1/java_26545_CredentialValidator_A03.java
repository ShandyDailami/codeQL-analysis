import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_26545_CredentialValidator_A03 {

    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        users.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public static class Credentials {
        private String username;
        private String password;

        public java_26545_CredentialValidator_A03(String username, String password) {
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

    public static class AuthenticationService {
        public boolean authenticate(Credentials credentials) {
            String expectedPassword = users.get(credentials.getUsername());
            return expectedPassword != null && expectedPassword.equals(Base64.getEncoder().encodeToString(credentials.getPassword().getBytes()));
        }
    }

    public static class SecurityController {
        private AuthenticationService authenticationService = new AuthenticationService();

        public boolean authenticateAndProceed(Credentials credentials) {
            if (authenticationService.authenticate(credentials)) {
                System.out.println("Access granted!");
                return true;
            } else {
                System.out.println("Access denied!");
                return false;
            }
        }
    }

    public static void main(String[] args) {
        SecurityController securityController = new SecurityController();
        securityController.authenticateAndProceed(new Credentials("user1", "password1"));
        securityController.authenticateAndProceed(new Credentials("user2", "wrongpassword"));
    }
}