import java.util.Base64;
import java.util.Base64.Decoder;

public class java_37905_CredentialValidator_A03 {

    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    public boolean validate(String user, String password) {
        Decoder decoder = Base64.getDecoder();
        String decodedPassword = new String(decoder.decode(password));

        return user.equals(VALID_USERNAME) && decodedPassword.equals(VALID_PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String encodedPassword = Base64.getEncoder().encodeToString("validPassword".getBytes());

        boolean isValid = validator.validate("validUser", encodedPassword);

        System.out.println("Is Valid? " + isValid);
    }
}