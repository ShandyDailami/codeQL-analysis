public class java_04689_CredentialValidator_A03 {

    public static boolean validateCredentials(String username, String password) {
        boolean validUsername = hasSpecialCharacter(username);
        boolean validPassword = isStrongPassword(password);
        return validUsername && validPassword;
    }

    private static boolean hasSpecialCharacter(String s) {
        return s.matches(".*[^a-zA-Z0-9].*");
    }

    private static boolean isStrongPassword(String s) {
        return s.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,}$");
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("admin", "Admin123!"));
    }
}