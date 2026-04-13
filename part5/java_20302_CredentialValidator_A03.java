import java.util.Base64;

public class java_20302_CredentialValidator_A03 {

    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "password";

    public boolean validate(String user, String password) {
        // Decode the username and password from base64
        String decodedUser = new String(Base64.getDecoder().decode(user), java.nio.charset.StandardCharsets.UTF_8);
        String decodedPassword = new String(Base64.getDecoder().decode(password), java.nio.charset.StandardCharsets.UTF_8);

        // Check if the decoded username and password match the valid ones
        return decodedUser.equals(VALID_USERNAME) && decodedPassword.equals(VALID_PASSWORD);
    }

}