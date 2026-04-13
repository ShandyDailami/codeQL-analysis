import java.util.Base64;

public class java_07813_CredentialValidator_A07 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String userCredentials = "admin:password";
        String base64Credentials = new String(Base64.getEncoder().encode((userCredentials).getBytes()));

        System.out.println("Base64 Credentials: " + base64Credentials);

        if (validateCredentials(base64Credentials)) {
            System.out.println("Credentials are valid!");
        } else {
            System.out.println("Authentication failed!");
        }
    }

    private static boolean validateCredentials(String base64Credentials) {
        String[] credentials = new String(Base64.getDecoder().decode(base64Credentials), java.nio.charset.StandardCharsets.UTF_8).split(":");
        return credentials[0].equals(USERNAME) && credentials[1].equals(PASSWORD);
    }
}