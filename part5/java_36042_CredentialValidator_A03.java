public class java_36042_CredentialValidator_A03 implements CredentialValidator {

    // Fields
    private UserService userService;

    // Constructor
    public java_36042_CredentialValidator_A03(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean validate(UsernamePasswordCredential token) throws AuthenticationException {
        // Extract credentials
        String username = token.getUsername();
        String password = token.getPassword();

        // Verify credentials
        User user = userService.findUserByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new AuthenticationFailedException("Invalid username or password");
        }

        // Validate user status
        if (!user.isActive()) {
            throw new AuthenticationFailedException("User is inactive");
        }

        // Validate user role
        if (!user.hasRole("ADMIN")) {
            throw new AuthenticationFailedException("Insufficient role");
        }

        // Authentication successful
        return true;
    }
}