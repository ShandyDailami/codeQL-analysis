import java.security.SecureRandom;

public class java_17937_CredentialValidator_A08 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public static boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (SPECIAL_CHARACTERS.contains(c + "")) {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        String password = "";

        for (int i = 0; i < 20; i++) {
            password += random.nextInt(10);
        }

        System.out.println("Generated password: " + password);

        if (validate(password)) {
            System.out.println("Password is strong enough!");
        } else {
            System.out.println("Password is not strong enough!");
        }
    }
}