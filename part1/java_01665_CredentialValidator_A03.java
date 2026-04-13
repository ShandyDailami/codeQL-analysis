public class java_01665_CredentialValidator_A03 {

    // This is the predefined pattern that the password must match
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9])(?=.{8,})";

    public static boolean validatePassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        String password = "Password1!";
        if (validatePassword(password)) {
            System.out.println("Password is valid!");
        } else {
            System.out.println("Password is not valid!");
        }
    }
}