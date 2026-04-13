public class java_28224_CredentialValidator_A08 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String password = "ThisIsAVeryStrongPassword";
        System.out.println(validator.validate(password));
    }

    public static class CredentialValidator {
        public boolean validate(String password) {
            if (password.length() < 8) {
                return false;
            }

            boolean hasUpperCase = false;
            boolean hasLowerCase = false;
            boolean hasDigit = false;

            for (char ch : password.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    hasUpperCase = true;
                } else if (Character.isLowerCase(ch)) {
                    hasLowerCase = true;
                } else if (Character.isDigit(ch)) {
                    hasDigit = true;
                }

                if (hasUpperCase && hasLowerCase && hasDigit) {
                    return true;
                }
            }

            return false;
        }
    }
}