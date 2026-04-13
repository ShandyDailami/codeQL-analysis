public class java_25155_CredentialValidator_A07 {
    // A static variable to keep track of the number of failed logins
    private static int failedLogins = 0;

    // Method to check if the provided password is correct
    public boolean validatePassword(String password) {
        // This is a placeholder. In a real application, you would have to call a
        // database to verify the password.
        if (password.equals("correctpassword")) {
            failedLogins = 0;
            return true;
        } else {
            failedLogins++;
            if (failedLogins > 3) {
                System.out.println("Too many failed logins. Account locked.");
                return false;
            }
            return false;
        }
    }
}