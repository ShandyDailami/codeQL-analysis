import java.util.Base64;
import java.util.Base64.Decoder;

public class java_13027_CredentialValidator_A03 {

    // This is a placeholder for real credentials
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    public static boolean validate(String username, String password) {
        Decoder decoder = Base64.getDecoder();

        // Decoding the credentials
        String decodedUser = new String(decoder.decode(username));
        String decodedPass = new String(decoder.decode(password));

        // Check if the decoded credentials match the placeholder
        return decodedUser.equals(USERNAME) && decodedPass.equals(PASSWORD);
    }

    public static void main(String[] args) {
        String credentials = "ZW5jb2RlZCB0ZXh0"; // Base64 of "test:test"

        // Validate the credentials
        boolean isValid = validate(credentials, "ZW5jb2RlZCB0ZXh0"); // Base64 of "test:test"

        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}