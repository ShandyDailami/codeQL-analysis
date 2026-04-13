public class java_20391_CredentialValidator_A08 {
    // Define an interface to abstract the difference between password strength
    public interface PasswordStrength {
        void evaluatePassword(String password);
    }

    // Define a class to handle password strength
    public static class PasswordStrengthChecker implements PasswordStrength {
        private int minPasswordLength = 8;
        private int minUppercaseLetters = 1;
        private int minLowercaseLetters = 1;
        private int minNumbers = 1;
        private int minSymbols = 1;

        public void setPassword(String password) {
            evaluatePassword(password);
        }

        public void evaluatePassword(String password) {
            int countUpper = 0;
            int countLower = 0;
            int countNumber = 0;
            int countSymbol = 0;

            if (password.length() < minPasswordLength) {
                System.out.println("Password is too short, it should be at least " + minPasswordLength + " characters long");
                return;
            }

            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (Character.isUpperCase(ch)) {
                    countUpper++;
                } else if (Character.isLowerCase(ch)) {
                    countLower++;
                } else if (Character.isDigit(ch)) {
                    countNumber++;
                } else {
                    countSymbol++;
                }
            }

            if (countUpper < minUppercaseLetters || countLower < minLowercaseLetters || 
                countNumber < minNumbers || countSymbol < minSymbols) {
                System.out.println("Password should contain at least " + minUppercaseLetters + " uppercase letters, " +
                                    minLowercaseLetters + " lowercase letters, " +
                                    minNumbers + " numbers, and " + minSymbols + " symbols");
                return;
            }

            System.out.println("Password is strong!");
        }
    }

    // Test the CredentialValidator
    public static void main(String[] args) {
        PasswordStrengthChecker checker = new PasswordStrengthChecker();
        checker.setPassword("Passw0rd!23");
        checker.setPassword("passw0rd!23");
        checker.setPassword("passw0rd!23456");
        checker.setPassword("passw0rd!234567");
        checker.setPassword("passw0rd!2345678");
    }
}