public class java_38531_CredentialValidator_A03 {
    private static final String STRONG_PASSWORD = "YourPassword123$";

    public static class Result {
        public boolean isStrongEnough;
        public String feedback;

        public java_38531_CredentialValidator_A03(boolean isStrongEnough, String feedback) {
            this.isStrongEnough = isStrongEnough;
            this.feedback = feedback;
        }
    }

    public Result validatePassword(String password) {
        if (password == null) {
            return new Result(false, "Password cannot be null");
        }

        if (password.length() < 8) {
            return new Result(false, "Password should be at least 8 characters long");
        }

        boolean containsDigit = false;
        boolean containsUpperCase = false;
        boolean containsLowerCase = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                containsDigit = true;
            } else if (Character.isUpperCase(c)) {
                containsUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                containsLowerCase = true;
            }

            if (containsDigit && containsUpperCase && containsLowerCase) {
                return new Result(true, "Password is strong");
            }
        }

        return new Result(false, "Password should contain at least one digit, one uppercase letter and one lowercase letter");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        Result result = validator.validatePassword(STRONG_PASSWORD);

        if (result.isStrongEnough) {
            System.out.println("Password is strong: " + result.feedback);
        } else {
            System.out.println("Password is not strong: " + result.feedback);
        }
    }
}