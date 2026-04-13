import java.util.Base64;
import java.util.Base64.Decoder;

public class java_29659_CredentialValidator_A03 {

    private static final String CORRECT_PASSWORD = "password";
    private static final String CORRECT_USERNAME = "username";

    public boolean validateCredentials(String username, String password) {
        Decoder decoder = Base64.getDecoder();

        try {
            String decodedPassword = new String(decoder.decode(password), "UTF-8");
            return username.equals(CORRECT_USERNAME) && decodedPassword.equals(CORRECT_PASSWORD);
        } catch (Exception e) {
            return false;
        }
    }
}