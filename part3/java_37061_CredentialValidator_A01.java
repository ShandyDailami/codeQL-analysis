public class java_37061_CredentialValidator_A01 {

    public interface Credential {
        String getUsername();
        String getPassword();
    }

    public interface CredentialValidator {
        boolean isValid(Credential credential);
    }

    public static class DefaultCredentialValidator implements CredentialValidator {

        private static final String DEFAULT_USERNAME = "admin";
        private static final String DEFAULT_PASSWORD = "password";

        @Override
        public boolean isValid(Credential credential) {
            return credential != null &&
                    (credential.getUsername().equals(DEFAULT_USERNAME) &&
                     credential.getPassword().equals(DEFAULT_PASSWORD));
        }
    }

    public static class SecureCredentialValidator implements CredentialValidator {

        private static final String SECURE_USERNAME = "admin";
        private static final String SECURE_PASSWORD = "securePassword";

        @Override
        public boolean isValid(Credential credential) {
            return credential != null &&
                    (credential.getUsername().equals(SECURE_USERNAME) &&
                     credential.getPassword().equals(SecureUtils.hashPassword(credential.getPassword())));
        }
    }

    public static class SecureUtils {

        public static String hashPassword(String password) {
            return hashPassword(password, "SHA-1");
        }

        public static String hashPassword(String password, String salt) {
            return DigestUtils.sha1Hex(salt + password);
        }
    }

    public static void main(String[] args) {
        Credential credential = () -> "admin", () -> "password";
        CredentialValidator validator = new DefaultCredentialValidator();
        System.out.println(validator.isValid(credential));

        validator = new SecureCredentialValidator();
        System.out.println(validator.isValid(credential));
    }
}