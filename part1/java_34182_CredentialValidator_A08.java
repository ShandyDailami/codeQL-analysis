public class java_34182_CredentialValidator_A08 {

    // Class to check password strength
    public static class PasswordChecker {

        public static boolean isStrongPassword(String password) {
            if (password == null) {
                throw new IllegalArgumentException("Password is null");
            }

            boolean digitFound = false;
            boolean uppercaseFound = false;
            boolean lowercaseFound = false;
            boolean specialCharacterFound = false;

            for (char c : password.toCharArray()) {
                if (Character.isDigit(c)) {
                    digitFound = true;
                } else if (Character.isUpperCase(c)) {
                    uppercaseFound = true;
                } else if (Character.isLowerCase(c)) {
                    lowercaseFound = true;
                } else if (!isValid(c)) {
                    specialCharacterFound = true;
                }

                if (digitFound && uppercaseFound && lowercaseFound && specialCharacterFound) {
                    return true;
                }
            }

            return false;
        }

        private static boolean isValid(char c) {
            return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || !isValid(c);
        }
    }

    // CredentialValidator
    public static class CredentialValidator implements javax.security.auth.login.CredentialValidator {

        public String getID() {
            return "PasswordChecker";
        }

        public String getCaller() {
            return "EnterpriseExample";
        }

        public String getTransports() {
            return "none";
        }

        public String getIssuer() {
            return "EnterpriseExample";
        }

        public String getNonce() {
            return null;
        }

        public String getEncryption() {
            return null;
        }

        public javax.security.auth.login.CredentialValidatorResult validate(javax.security.auth.login.CredentialCredential c) {
            String password = c.getCredential();
            boolean strongPassword = PasswordChecker.isStrongPassword(password);
            return new javax.security.auth.login.CredentialValidatorResult(strongPassword);
        }
    }
}