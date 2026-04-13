public class java_07539_CredentialValidator_A08 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        validateCredentials("username", "password");
    }

    public static void validateCredentials(String username, String password) {
        if (isCredentialsValid(username, password)) {
            System.out.println("Credentials validated successfully.");
        } else {
            System.out.println("Credentials invalid. Access denied.");
        }
    }

    public static boolean isCredentialsValid(String username, String password) {
        return isPasswordSufficient(username, password) && isUsernameAndPasswordMatch(username, password);
    }

    private static boolean isPasswordSufficient(String username, String password) {
        return true; // Here you should add a stronger password policy and validation
    }

    private static boolean isUsernameAndPasswordMatch(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}