import java.util.Base64;

public class java_00095_CredentialValidator_A01 {

    public static boolean validateCredentials(String username, String password, String expectedUsername, String expectedPassword) {
        // Decode expected credentials
        byte[] decodedExpectedPassword = Base64.getDecoder().decode(expectedPassword);
        String expectedPasswordDecoded = new String(decodedExpectedPassword);

        // Decode actual credentials
        byte[] decodedActualPassword = Base64.getDecoder().decode(password);
        String actualPasswordDecoded = new String(decodedActualPassword);

        // Validate credentials
        return username.equals(expectedUsername) && actualPasswordDecoded.equals(expectedPasswordDecoded);
    }

    public static void main(String[] args) {
        String username = "admin";
        String password = "ZW5jb2RlZCB0ZXh0";
        String expectedUsername = "admin";
        String expectedPassword = "ZW5jb2RlZCB0ZXh0";

        if (validateCredentials(username, password, expectedUsername, expectedPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}