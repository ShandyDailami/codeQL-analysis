public class java_00050_CredentialValidator_A07 {

    // Create a password authentication
    private PasswordAuthentication authentication = new PasswordAuthentication("user", "password".toCharArray());

    public boolean validate(String user, String password) {
        // Compare the input password with the stored password
        if (password != null && password.equals(new String(authentication.getPassword()))) {
            // If passwords match, return true
            return true;
        } else {
            // If passwords do not match, return false
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Initially, let's assume that the user is not authenticated
        boolean isAuthenticated = false;

        while(!isAuthenticated) {
            System.out.println("Enter username:");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();

            isAuthenticated = validator.validate(username, password);

            if (!isAuthenticated) {
                System.out.println("Invalid credentials. Please try again.");
            }
        }

        System.out.println("You are now authenticated.");
    }
}