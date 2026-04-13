public class java_19338_CredentialValidator_A03 {

    // Stored credentials
    private String username = "admin";
    private String password = "password";

    // Method to check if the provided credentials match the stored ones
    public boolean validate(String user, String pass) {
        if (user != null && pass != null) {
            // Check if provided credentials match stored credentials
            if (user.equals(username) && pass.equals(password)) {
                return true;
            }
        }
        return false;
    }
}