public class java_16103_CredentialValidator_A08 {

    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCase = true;
            } else if (Character.isLowerCase(c)) {
                lowerCase = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            }

            if (upperCase && lowerCase && digit) {
                return true;
            }
        }

        return false;
    }
}