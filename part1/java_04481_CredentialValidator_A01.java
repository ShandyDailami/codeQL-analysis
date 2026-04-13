public class java_04481_CredentialValidator_A01 {
    private static final String GOOD_USERNAME = "admin";
    private static final String GOOD_PASSWORD = "password";

    public static CredentialValidationResult validate(String username, String password) {
        if (username.equals(GOOD_USERNAME) && password.equals(GOOD_PASSWORD)) {
            return CredentialValidationResult.SUCCESS;
        } else {
            return CredentialValidationResult.FAILURE;
        }
    }

    public static void main(String[] args) {
        String goodUsername = "admin";
        String goodPassword = "password";
        CredentialValidationResult result = validate(goodUsername, goodPassword);

        if (result == CredentialValidationResult.SUCCESS) {
            System.out.println("Login successful!!");
        } else {
            System.out.println("Access denied, wrong credentials.");
        }
    }
}

enum CredentialValidationResult {
    SUCCESS, FAILURE
}