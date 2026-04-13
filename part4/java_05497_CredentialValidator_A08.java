import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_05497_CredentialValidator_A08 {

    // Simple password check
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("password");

    public static boolean validate(String credential) {
        // Decode base64 to get the password
        byte[] decodedBytes = Base64.getDecoder().decode(credential);
        String decodedCredential = new String(decodedBytes);

        // Use Matcher to find the pattern in the credential
        Matcher matcher = PASSWORD_PATTERN.matcher(decodedCredential);

        // If the password matches the pattern, return true
        return matcher.find();
    }

    public static void main(String[] args) {
        // Create a base64 encoded password
        String password = Base64.getEncoder().encodeToString("password".getBytes());

        // Validate the password
        boolean isValid = validate(password);

        // Print the result
        System.out.println("Is password valid? " + isValid);
    }
}