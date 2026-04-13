public class java_22215_CredentialValidator_A01 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("user", "password");
    }

    public void validate(String username, String password) {
        if (isValid(username, password)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private boolean isValid(String username, String password) {
        // Hard-coded credentials
        String hardCodedUsername = "admin";
        String hardCodedPassword = "password";

        return username.equals(hardCodedUsername) && password.equals(hardCodedPassword);
    }
}