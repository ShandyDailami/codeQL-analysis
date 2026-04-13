public class java_16890_CredentialValidator_A01 {

    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    public static CredentialValidationResult validate(CredentialValidationContext context) {

        CredentialValidationResult result = new CredentialValidationResult();

        // Get the credentials from the context
        String username = context.getCallerPrincipal().getName();
        String password = context.getCredentials().toString();

        // Check if the provided credentials match the expected ones
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            result.setAuthenticated(true);
        } else {
            result.setAuthenticated(false);
        }

        return result;
    }

    public static void main(String[] args) {
        // This is just a simple test. In real applications, you would need to use a more
        // complex CredentialValidationContext to test your CredentialValidator.
        CredentialValidationContext context = new CredentialValidationContext();
        context.setCallerPrincipal(new User(VALID_USERNAME));
        context.setCredentials(VALID_PASSWORD);

        CredentialValidationResult result = validate(context);

        System.out.println("Is Authenticated? " + result.isAuthenticated());
    }
}