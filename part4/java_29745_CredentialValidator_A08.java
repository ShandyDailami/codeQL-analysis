public class java_29745_CredentialValidator_A08 {

    public static void validatePassword(String password) throws Exception {
        if (password == null || password.length() < 8) {
            throw new Exception("Password must be at least 8 characters long and must contain a digit, a special character, and a lowercase letter.");
        }
        
        boolean isDigit = false;
        boolean isSpecial = false;
        boolean isLowerCase = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                isDigit = true;
            } else if (Character.isLowerCase(c)) {
                isLowerCase = true;
            } else if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".indexOf(c) != -1) {
                isSpecial = true;
            }
        }

        if (!(isDigit && isSpecial && isLowerCase)) {
            throw new Exception("Password must contain a digit, a special character, and a lowercase letter.");
        }
    }

    public static void main(String[] args) {
        try {
            validatePassword("password");
            validatePassword("password1");
            validatePassword("PASSWORD1");
            validatePassword("PASSWORD1!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}