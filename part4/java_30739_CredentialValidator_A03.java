public class java_30739_CredentialValidator_A03 {

    // No constructor required
    private java_30739_CredentialValidator_A03() {
    }

    // A simple check to ensure passwords are not null and not empty
    public static boolean isValidPassword(String password) {
        return password != null && !password.isEmpty();
    }

    // A simple check to ensure usernames are not null and not empty
    public static boolean isValidUsername(String username) {
        return username != null && !username.isEmpty();
    }

    // A credential validation method that checks both username and password
    public static boolean validate(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }

}