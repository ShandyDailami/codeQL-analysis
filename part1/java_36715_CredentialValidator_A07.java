import java.security.Key;
import java.util.Base64;
import java.util.Map;
import java.util.HashMap;

public class java_36715_CredentialValidator_A07 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", USERNAME);
        credentials.put("password", PASSWORD);

        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.toString().getBytes());

        System.out.println("Encoded Credentials: " + encodedCredentials);

        String enteredCredentials = new String(Base64.getDecoder().decode(encodedCredentials));

        System.out.println("Entered Credentials: " + enteredCredentials);

        String[] splitCredentials = enteredCredentials.split(",");

        String decodedUsername = new String(Base64.getDecoder().decode(splitCredentials[0].getBytes()));
        String decodedPassword = new String(Base64.getDecoder().decode(splitCredentials[1].getBytes()));

        System.out.println("Decoded Username: " + decodedUsername);
        System.out.println("Decoded Password: " + decodedPassword);

        if (validate(decodedUsername, decodedPassword)) {
            System.out.println("Authentication Successful");
        } else {
            System.out.println("Authentication Failed");
        }
    }
}