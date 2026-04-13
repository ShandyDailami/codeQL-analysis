import java.util.Base64;

public class java_06506_CredentialValidator_A03 {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public boolean validate(String username, String password) {
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordString = new String(decodedPassword);

        return username.equals(VALID_USERNAME) && decodedPasswordString.equals(VALID_PASSWORD);
    }
}