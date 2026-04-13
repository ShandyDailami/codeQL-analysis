import java.util.Base64;
import java.util.HashMap;

public class java_12236_CredentialValidator_A03 {
    private static HashMap<String, String> users = new HashMap<>();

    static {
        users.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    public static class Credentials {
        private final String username;
        private final String password;

        public java_12236_CredentialValidator_A03(String username, String password) {
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

    public static boolean validate(Credentials credentials) {
        String password = users.get(credentials.getUsername());

        if (password == null) {
            throw new IllegalArgumentException("Invalid username");
        } else if (!password.equals(Base64.getEncoder().encodeToString(credentials.getPassword().getBytes()))) {
            throw new IllegalArgumentException("Invalid password");
        }

        return true;
    }
}