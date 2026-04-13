public class java_01509_CredentialValidator_A01 {
    // This is a placeholder for a hard-coded credentials.
    // In a real application, it would come from a database or other persistent storage.
    private String hardCodedUsername = "admin";
    private String hardCodedPassword = "password";

    // This method performs the actual validation.
    // It returns true if the provided credentials are valid, false otherwise.
    public boolean isValid(String username, String password) {
        return username.equals(hardCodedUsername) && password.equals(hardCodedPassword);
    }
}