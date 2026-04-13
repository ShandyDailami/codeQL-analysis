public class java_00156_CredentialValidator_A03 {
    // Define the pattern to match
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_]+$";

    // Define the username
    private String username;

    // Constructor
    public java_00156_CredentialValidator_A03(String username) {
        this.username = username;
    }

    // Method to validate the username
    public boolean isValid() {
        // Use Matcher to match the username against the pattern
        Matcher matcher = Pattern.compile(USERNAME_PATTERN).matcher(this.username);

        // If the username matches the pattern, it is valid
        return matcher.matches();
    }
}