import java.util.Base64;

public class java_24325_CredentialValidator_A08 {

    // This method will validate if the username and password provided are correct
    public boolean isValidCredentials(String user, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        // This is a placeholder for a more secure way to check credentials
        // Replace this with a real implementation
        return user.equals("admin") && encodedPassword.equals("dGVzdCBjb2Rl");
    }

}