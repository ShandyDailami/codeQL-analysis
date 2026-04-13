public class java_23304_CredentialValidator_A07 {

    // Dependency: UserManager
    private UserManager userManager;

    // Dependency: CredentialValidator
    private CredentialValidator validator;

    public java_23304_CredentialValidator_A07(UserManager userManager, CredentialValidator validator) {
        this.userManager = userManager;
        this.validator = validator;
    }

    public CredentialValidationResult validate(Credential c) {
        // 1. Retrieve the username and password from the Credential object.
        String username = c.getIdentifier();
        String password = c.getCredential();

        // 2. Verify the username and password using the user manager.
        User user = userManager.findUser(username);
        if (user == null || !user.isValidPassword(password)) {
            return new CredentialValidationResult(username, false);
        }

        // 3. Validate the user's security credentials.
        if (!user.validateCredentials()) {
            return new CredentialValidationResult(username, false);
        }

        // 4. Validate the user's authentication status.
        if (!user.isAuthenticated()) {
            return new CredentialValidationResult(username, false);
        }

        // 5. Validate the user's authorization status.
        if (!user.isAuthorized()) {
            return new CredentialValidationResult(username, false);
        }

        // 6. Return a successful result.
        return new CredentialValidationResult(username, true);
    }
}