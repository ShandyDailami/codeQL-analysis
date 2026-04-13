import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_12955_CredentialValidator_A03 {

    private static Map<String, String> userDatabase = new HashMap<>();

    static {
        userDatabase.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
        userDatabase.put("user", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    public static class CustomValidator implements javax.security.auth.credential.CredentialValidator {

        @Override
        public String getName() {
            return "Custom Validator";
        }

        @Override
        public String validate(String credentials) {
            String[] credentialParts = new String(Base64.getDecoder().decode(credentials)).split(":");
            String username = credentialParts[0];
            String password = credentialParts[1];

            String correctPassword = userDatabase.get(username);

            if (correctPassword != null && correctPassword.equals(password)) {
                return "VALID";
            } else {
                return "INVALID";
            }
        }

        @Override
        public void initialize(String arguments) throws CertificateException {
            // Do nothing, this method is not used in our case
        }

        @Override
        public void delete() {
            // Do nothing, this method is not used in our case
        }

        @Override
        public boolean supports(String authType) {
            return authType.equals("BASIC");
        }
    }

    public static void main(String[] args) {
        javax.security.auth.credential.CredentialValidator validator = new CustomValidator();
        // Use the validator to authenticate a user
        // ...
    }
}