public class java_36931_CredentialValidator_A01 {

    public static boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        int numOfDigits = 0, numOfUpperCase = 0, numOfSpecialChars = 0;
        boolean isDigit, isUpperCase, isSpecialChar;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isDigit(ch)) {
                numOfDigits++;
                isDigit = true;
            } else if (Character.isUpperCase(ch)) {
                numOfUpperCase++;
                isUpperCase = true;
            } else if (!"A-Za-z0-9/~!@#$%^&*()_+=`-={}[]|\\:;'<,>.?/".contains(String.valueOf(ch))) {
                numOfSpecialChars++;
                isSpecialChar = true;
            }
        }

        return (isDigit && isUpperCase && isSpecialChar && numOfDigits > 0 && numOfUpperCase > 0 && numOfSpecialChars > 0 && password.matches(".*[A-Za-z0-9].*"));
    }
}