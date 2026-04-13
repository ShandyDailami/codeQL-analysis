import java.security.SecureRandom;

public class java_21135_CredentialValidator_A07 {
    private static final SecureRandom random = new SecureRandom();

    public static class AuthContext {
        private final String password;
        private final String token;

        public java_21135_CredentialValidator_A07(String password, String token) {
            this.password = password;
            this.token = token;
        }

        public String getPassword() {
            return password;
        }

        public String getToken() {
            return token;
        }
    }

    public static AuthContext validate(String password, String token) {
        if (password == null || password.isEmpty() || token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Password and token must be provided");
        }

        if (password.equals("wrongPassword") && token.equals("wrongToken")) {
            throw new AuthenticationFailedException("Invalid password or token");
        }

        return new AuthContext(password, token);
    }

    public static class AuthenticationFailedException extends RuntimeException {
        public java_21135_CredentialValidator_A07(String message) {
            super(message);
        }
    }
}