public class java_27923_CredentialValidator_A01 {

    // Method to check if the password is valid
    public boolean isValid(String password) {
        if (password == null) {
            return false;
        }

        // Check if password is longer than 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Check if password has at least one digit
        if (!hasDigit(password)) {
            return false;
        }

        // Check if password has at least one uppercase letter
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check if password has at least one special character
        if (!hasSpecialChar(password)) {
            return false;
        }

        // If all checks are passed, password is valid
        return true;
    }

    // Method to check if password contains digit
    private boolean hasDigit(String password) {
        return password.matches(".*\\d.*");
    }

    // Method to check if password contains uppercase letter
    private boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    // Method to check if password contains special character
    private boolean hasSpecialChar(String password) {
        return password.matches(".*[!@#$%^&*()_+\\-={}|;:\\\"\\\'\\\\\\[\\]\\\\`~].*");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println("Enter a password:");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        if (validator.isValid(password)) {
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }
    }
}