public class java_19061_CredentialValidator_A07 implements CredentialValidator {

    private String username;
    private String password;

    public java_19061_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Result validate(CredentialContext context) {
        if (context.getAuthentication().getCredentials() == null) {
            return Result.failure();
        }

        String providedUsername = context.getAuthentication().getCredentials().toString();
        String providedPassword = context.getAuthentication().getPasswd().toString();

        if (!username.equals(providedUsername) || !password.equals(providedPassword)) {
            return Result.failure();
        }

        return Result.success();
    }
}