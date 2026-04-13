import java.util.Base64;

public class java_11648_CredentialValidator_A03 {

    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "password";

    public static boolean validate(String username, String password) {
        String providedCredentials = username + ":" + password;
        String encodedCredentials = new String(Base64.getEncoder().encode(providedCredentials.getBytes()));

        // For simplicity, we assume the encoded credentials are always correct.
        // In reality, you would likely want to compare the encoded credentials to the actual credentials stored in a database.
        return encodedCredentials.equals("dGVzdHJ1c3RlZDpkZXZlbHM=");
    }

    public static void main(String[] args) {
        String username = "user";
        String password = "password";
        if (validate(username, password)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}