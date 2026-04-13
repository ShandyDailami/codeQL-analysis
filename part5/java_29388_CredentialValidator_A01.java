public class java_29388_CredentialValidator_A01 {
    public static boolean validate(String password) {
        // Remove the comment if you want to use regular expressions
        // if (!password.matches("[a-zA-Z0-9]*")) {
        //     return false;
        // }

        // If password is null or empty, it is invalid
        if (password == null || password.isEmpty()) {
            return false;
        }

        // If password contains only numbers, it is invalid
        if (password.matches(".*\\d.*")) {
            return false;
        }

        // If password contains only letters, it is invalid
        if (password.matches(".*[^a-zA-Z].*")) {
            return false;
        }

        // If password contains non-alphanumeric characters, it is invalid
        if (password.matches(".*[^a-zA-Z0-9].*")) {
            return false;
        }

        return true;
    }
}