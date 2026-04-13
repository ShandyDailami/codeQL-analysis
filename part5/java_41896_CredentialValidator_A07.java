import org.apache.commons.codec.binary.Base64;

public class java_41896_CredentialValidator_A07 {

    public static class AuthFailureException extends Exception {
        public java_41896_CredentialValidator_A07(String message) {
            super(message);
        }
    }

    public static boolean authenticate(String user, String password) {
        if ("admin".equals(user) && "password".equals(password)) {
            return true;
        }
        throw new AuthFailureException("Invalid credentials");
    }

    public static void main(String[] args) {
        try {
            authenticate("admin", "wrongpassword");
        } catch (AuthFailureException e) {
            System.out.println(e.getMessage());
        // Prints "Invalid credentials"
        }
    }
}