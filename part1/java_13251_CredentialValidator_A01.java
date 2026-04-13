public class java_13251_CredentialValidator_A01 implements CredentialValidator {

    private HashMap<String, String> users = new HashMap<>();

    public java_13251_CredentialValidator_A01() {
        users.put("user1", "pbkdf2:sha256:100000$L9JhJM9L$C0F10B20$a346d9d4963679a5$2336$1$20$a2f31e8867d09f97$a2f31e8867d09f97"); // password is "password"
        users.put("user2", "pbkdf2:sha256:100000$L9JhJM9L$C0F10B20$a346d9d4963679a5$2336$1$20$a2f31e8867d09f97$a2f31e8867d09f97"); // password is "password"
    }

    @Override
    public boolean validate(CredentialContext credentialContext) throws AuthenticationFailed {
        String presentedPassword = credentialContext.getPassword();
        String username = credentialContext.getCallerPrincipal();

        if (!users.containsKey(username)) {
            throw new AuthenticationFailed("User not found");
        }

        String expectedPassword = users.get(username);

        if (!PasswordUtil.matches(presentedPassword, expectedPassword)) {
            throw new AuthenticationFailed("Invalid password");
        }

        return true;
    }
}