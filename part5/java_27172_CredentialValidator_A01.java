public class java_27172_CredentialValidator_A01 {
    public static boolean validateCredentials(String username, String password) {
        // Simulate a process where we wait for a short period of time
        // This is a placeholder and not secure for real-world applications
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check if the username and password are correct.
        // For real world applications, these should be checked against a database or a more secure source.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Usage of the validateCredentials method
        boolean isValid = validateCredentials("admin", "password");
        if (isValid) {
            System.out.println("Credentials are valid!");
        } else {
            System.out.println("Credentials are not valid!");
        }
    }
}