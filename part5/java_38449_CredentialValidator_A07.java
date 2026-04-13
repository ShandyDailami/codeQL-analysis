import java.security.Principal;

public class java_38449_CredentialValidator_A07 implements java.security.Authenticator.CredentialValidator {

    // This is a dummy authentication method. In a real-world scenario,
    // this would use your own authentication method to compare the submitted password with
    // the one in the database.
    private static boolean authenticate(String username, String password) {
        // Add your own authentication logic here. This is just a dummy.
        return username.equals("user") && password.equals("password");
    }

    @Override
    public Principal validate(String username, String password) {
        if (authenticate(username, password)) {
            return new Principal() {
                @Override
                public String getName() {
                    return username;
                }
            };
        } else {
            throw new java.security.AuthenticationException("Invalid username or password");
        }
    }
}