public class java_24290_CredentialValidator_A07 {

    private UserService userService;

    public java_24290_CredentialValidator_A07(UserService userService) {
        this.userService = userService;
    }

    public boolean validateCredentials(String username, String password) {
        // Step 1: Check if user is authenticated
        if (!userService.isUserAuthenticated(username)) {
            // If not, print error and return false
            System.out.println("Invalid username or password");
            return false;
        }

        // Step 2: Check if user has right password
        if (!userService.checkPassword(username, password)) {
            // If not, print error and return false
            System.out.println("Invalid username or password");
            return false;
        }

        // If both checks pass, return true
        return true;
    }
}