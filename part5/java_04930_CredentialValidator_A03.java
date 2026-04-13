import java.util.Base64;
import java.util.Map;

public class java_04930_CredentialValidator_A03 {

    public static class CredentialInfo {
        public String username;
        public String password;

        public java_04930_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    public static class CredentialValidatorImpl implements CredentialValidator.CredentialValidator {

        @Override
        public boolean isValidCredential(CredentialInfo credentialInfo) {
            if (credentialInfo.username != null && credentialInfo.username.length() > 5) {
                return false;
            }
            if (credentialInfo.password != null && credentialInfo.password.length() > 8) {
                return false;
           
            }
            return true;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidatorImpl();

        Map<String, String> testCredentials = Map.of("user1", "password1", "user2", "password2");

        for (Map.Entry<String, String> entry : testCredentials.entrySet()) {
            CredentialInfo credentialInfo = new CredentialInfo(entry.getKey(), entry.getValue());
            boolean isValid = validator.isValidCredential(credentialInfo);
            System.out.println("Username: " + credentialInfo.username + ", Valid: " + isValid);
        }
    }
}