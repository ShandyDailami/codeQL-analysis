public class java_38989_CredentialValidator_A07 implements CredentialValidator {

    private String username;
    private String password;

    public java_38989_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Result validate(CredentialContext context) {
        // get the credentials from the context
        String providedUsername = context.getCredentials().get("username");
        String providedPassword = context.getCredentials().get("password");

        // validate the credentials
        if (this.username.equals(providedUsername) && this.password.equals(providedPassword)) {
            return Result.success();
        } else {
            return Result.failure("Invalid username or password");
        }
    }
}