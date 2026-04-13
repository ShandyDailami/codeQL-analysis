public class java_06464_CredentialValidator_A03 {
    // 4. Create a method that validates the password
    public static boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        // 5. Use regular expressions to check the password's strength
        // A password is considered strong if it is at least 8 characters long, contains a digit, uppercase letter, lowercase letter, and special character
        if (password.length() < 8 || !password.matches(".*\\d.*") || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*[^a-zA-Z0-9].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // 6. Test the method with a list of passwords
        String[] passwords = {"password", "Password", "password1", "Password!", "P@ssw0rd", "P@ssword123"};

        for (String password : passwords) {
            if (isPasswordStrong(password)) {
                System.out.println(password + " is strong");
            } else {
                System.out.println(password + " is weak");
            }
        }
    }
}