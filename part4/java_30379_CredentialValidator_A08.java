import java.util.Base64;

public class java_30379_CredentialValidator_A08 {

    public boolean validate(String user, String password) {
        // This is a very simple validation. In a real application, you would want to use a more secure method of comparison.
        // For example, you could compare hashed passwords stored in the database, not plain text.
        String expectedPassword = "d08a1cbe7088c9b59f498f85b88e04499f69b9ff8229779c0"; // This is a sample hashed password

        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedExpectedPassword = new String(decodedPassword);

        if (user.equals("test") && decodedExpectedPassword.equals("test")) {
            return true;
        } else {
            return false;
        }
    }
}