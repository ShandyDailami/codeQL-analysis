import java.util.Base64;
import java.util.Base64.Decoder;

public class java_37431_CredentialValidator_A03 {

    public boolean validate(String username, String password) {
        // Convert the password to Base64
        Decoder decoder = Base64.getDecoder();
        String base64Password = new String(decoder.decode(password));

        // Verify the password against a hard-coded example
        if (base64Password.equals("dGVzdHk=")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String username = "user";
        String password = "YWJjZGVmZzEyMzQ1Njc4MWFiY2Q6";  // "user:pass" encoded in Base64
        boolean isValid = validator.validate(username, password);
        System.out.println("Is valid: " + isValid);
    }
}