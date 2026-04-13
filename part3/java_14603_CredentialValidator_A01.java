import java.security.InvalidParameterException;
import java.util.Base64;

public class java_14603_CredentialValidator_A01 {

    private static final String USERNAME_PREFIX = "USERNAME_";
    private static final String PASSWORD_PREFIX = "PASSWORD_";

    public static Credentials createValidCredentials(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }

        String encodedUsername = Base64.getEncoder().encodeToString(username.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        return new Credentials(USERNAME_PREFIX + encodedUsername, PASSWORD_PREFIX + encodedPassword);
    }

    public static boolean isCredentialsValid(Credentials credentials, String username, String password) {
        if (credentials == null) {
            throw new InvalidParameterException("Credentials must be provided");
        }

        String decodedUsername = new String(Base64.getDecoder().decode(credentials.getUsername()));
        String decodedPassword = new String(Base64.getDecoder().decode(credentials.getPassword()));

        return username.equals(decodedUsername) && password.equals(decodedPassword);
    }

    public static class Credentials {
        private String username;
        private String password;

        public java_14603_CredentialValidator_A01(String username, String password) {
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
}