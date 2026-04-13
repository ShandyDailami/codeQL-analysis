public class java_41247_CredentialValidator_A01 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static class CredentialChecker implements com.example.CredentialChecker {
        @Override
        public boolean isValidUsernameAndPassword(String username, String password) {
            return username.equals(USERNAME) && password.equals(PASSWORD);
        }
    }

    public static void main(String[] args) {
        CredentialChecker credentialChecker = new CredentialChecker();

        // You can now use credentialChecker to validate credentials
        boolean valid = credentialChecker.isValidUsernameAndPassword("admin", "password");

        if (valid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}