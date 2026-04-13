public class java_26999_CredentialValidator_A08 {

    public static boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            return false;
        }

        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean specialChar = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                upperCase = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCase = true;
            } else if (Character.isDigit(ch)) {
                digit = true;
            } else if (!isSpecialCharacter(ch)) {
                specialChar = true;
            }

            if (upperCase && lowerCase && digit && specialChar) {
                return true;
            }
        }

        return false;
    }

    private static boolean isSpecialCharacter(char ch) {
        return (ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z') && (ch < '0' || ch > '9') && (ch != '.' && ch != ',' && ch != ' ');
    }

}