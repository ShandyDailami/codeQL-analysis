public class java_02882_CredentialValidator_A01 {

    public static boolean validatePassword(String password) {
        // This is a very simple check for a weak password. 
        // A real password validator would have more complex rules.
        return password != null && !password.isEmpty();
    }

    public static boolean validateEmail(String email) {
        // This is a very simple check for an invalid email address.
        // A real email validator would have more complex rules.
        if (email != null && !email.isEmpty()) {
            String emailRegex = "^(.+)@(.+)$";
            return email.matches(emailRegex);
        }
        return false;
    }

    public static boolean validateCredentials(String password, String email) {
        // Validate password and email
        return validatePassword(password) && validateEmail(email);
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("password", "email@example.com"));
    }
}