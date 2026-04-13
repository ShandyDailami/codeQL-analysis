public class java_36345_CredentialValidator_A07 {

    public static void main(String[] args) {
        String password = "password"; // Replace with your password
        if (isValid(password)) {
            System.out.println("Valid password.");
        } else {
            System.out.println("Invalid password.");
        }
    }

    public static boolean isValid(String password) {
        if (password.length() > 8) {
            if (password.matches(".*\\d.*")) {
                if (password.matches(".*[a-z].*")) {
                    if (password.matches(".*[A-Z].*")) {
                        if (password.matches(".*[^a-zA-Z0-9].*")) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}