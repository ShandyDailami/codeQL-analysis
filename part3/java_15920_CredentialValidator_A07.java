public class java_15920_CredentialValidator_A07 {

    // Method to validate if a password meets the requirements (length, uppercase, lowercase, digit, special character)
    public boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean upperCase = false, lowerCase = false, digit = false, specialCharacter = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) upperCase = true;
            if (Character.isLowerCase(c)) lowerCase = true;
            if (Character.isDigit(c)) digit = true;
            if (!isSpecialCharacter(c)) specialCharacter = true;
            if (upperCase && lowerCase && digit && specialCharacter) return true;
        }

        return false;
    }

    // Method to check if a character is a special character
    private boolean isSpecialCharacter(char c) {
        return !(c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']' || c == '<' || c == '>' || c == ';' || c == ':' || c == '.' || c == ',');
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validatePassword("Password@123")); // true
        System.out.println(validator.validatePassword("password")); // false
    }
}