import java.util.Base64;

public class java_39440_CredentialValidator_A01 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String providedCredentials = "Basic " + Base64.getEncoder().encodeToString("admin:password".getBytes());

        validateCredentials(providedCredentials);
    }

    public static void validateCredentials(String providedCredentials) {
        // Remove the comment below when you are satisfied with the code
        // System.out.println(validateCredentials(providedCredentials));
    }

    public static boolean validateCredentials(String providedCredentials) {
        if (providedCredentials == null) {
            return false;
        }

        String[] credentials = new String(Base64.getDecoder().decode(providedCredentials), "UTF-8").split(":", 2);

        if (credentials.length != 2) {
            return false;
        }

        if (USERNAME.equals(credentials[0]) && PASSWORD.equals(credentials[1])) {
            return true;
        }

        return false;
    }
}