public class java_09182_CredentialValidator_A07 {
    public boolean validate(String username, String password) {
        if (username == null || username.length() == 0) {
            return false;
        }

        boolean upperCase = false, lowerCase = false, digit = false, specialChars = false;
        int length = 0;

        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);

            if (Character.isUpperCase(ch)) upperCase = true;
            if (Character.isLowerCase(ch)) lowerCase = true;
            if (Character.isDigit(ch)) digit = true;
            if (!isSpecialCharacter(ch)) specialChars = true;

            length++;
        }

        if (!(upperCase && lowerCase && digit && specialChars && length >= 8)) {
            return false;
        }

        return true;
    }

    private boolean isSpecialCharacter(char ch) {
        return !(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9');
    }
}