public class java_03991_CredentialValidator_A03 {
    private CredentialProvider provider;

    public java_03991_CredentialValidator_A03(CredentialProvider provider) {
        this.provider = provider;
    }

    public boolean isValid(String username, String password) {
        // Step 1: Retrieve the user from the provider
        User user = provider.getUser(username);

        // Step 2: Check if the user exists
        if (user == null) {
            System.out.println("User does not exist");
            return false;
        }

        // Step 3: Verify the password
        if (!user.getPassword().equals(password)) {
            System.out.println("Invalid password");
            return false;
        }

        // Step 4: Validate the user
        if (!user.isActive()) {
            System.out.println("User is inactive");
            return false;
        }

        // If we've made it this far, the user is valid
        return true;
    }
}