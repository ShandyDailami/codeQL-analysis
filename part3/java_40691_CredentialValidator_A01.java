public class java_40691_CredentialValidator_A01 {

    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean specialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCase = true;
            } else if (Character.isLowerCase(c)) {
                lowerCase = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            } else if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".indexOf(c) == -1) {
                specialChar = true;
            }

            if (upperCase && lowerCase && digit && specialChar) {
                return true;
            }
        }

        return false;
    }
}