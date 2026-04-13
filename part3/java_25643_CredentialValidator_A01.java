import java.util.Base64;

public class java_25643_CredentialValidator_A01 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String userCredentials = "Basic " + Base64.getEncoder().encodeToString(USERNAME.getBytes());

        if (validateCredentials(userCredentials)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    public static boolean validateCredentials(String credentials) {
        if (credentials == null || !credentials.startsWith("Basic ")) {
            return false;
        }

        String decodedCredentials = new String(Base64.getDecoder().decode(credentials.substring("Basic ".length())), "UTF-8");
        String[] usernameAndPassword = decodedCredentials.split(":", 2);

        return USERNAME.equals(usernameAndPassword[0]) && PASSWORD.equals(usernameAndPassword[1]);
    }
}