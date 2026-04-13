import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.login.LoginModule;

public class java_02480_CredentialValidator_A01 implements LoginModule {

    private Map<String, String> credentials;

    public java_02480_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
    }

    @Override
    public CredentialValidationResult validate(Map<String, String> credentials) throws CredentialNotFoundException, LoginException {
        this.credentials = credentials;
        String username = credentials.get("username");
        String password = credentials.get("password");

        // Hash the password for comparison
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(password.getBytes());
            String hashPassword = Base64.getEncoder().encodeToString(hashBytes);

            // Check if the username and hashed password match
            if (username.equals(this.credentials.get("username")) && this.credentials.get("password").equals(hashPassword)) {
                return CredentialValidationResult.success();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return CredentialValidationResult.failure();
    }

    public static void main(String[] args) {
        CustomCredentialValidator credentialValidator = new CustomCredentialValidator();
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", "admin");
        credentials.put("password", "password");

        try {
            CredentialValidationResult result = credentialValidator.validate(credentials);
            if (result.getResult() == CredentialValidationResult.SUCCESS) {
                System.out.println("Login successful");
            } else {
                System.out.println("Invalid credentials");
            }
        } catch (LoginException | CredentialNotFoundException e) {
            e.printStackTrace();
        }
    }
}