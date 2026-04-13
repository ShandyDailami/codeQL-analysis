public class java_36526_CredentialValidator_A03 {

    public boolean validateCredentials(String username, String password) {
        // Step 1: Check if the provided username and password are not null.
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password must be provided");
        }

        // Step 2: Perform a simple comparison between the provided username and password.
        // This is a simplistic example, in a real scenario, you would likely want to hash the password and compare the hashes.
        boolean isValid = username.equals("admin") && password.equals("password");

        // Step 3: If the provided username and password match the expected values, return true. Otherwise, return false.
        if (isValid) {
            System.out.println("Credentials are valid");
        } else {
            System.out.println("Credentials are invalid");
        }

        return isValid;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials("admin", "password");
    }
}