public class java_21583_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_21583_CredentialValidator_A07() {
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    @Override
    public AuthenticationStatus validate(AuthenticationToken token) {
        String name = token.getIdentity().toString();
        String credential = token.getCredentials().toString();

        if(credentials.containsKey(name) && credentials.get(name).equals(credential)) {
            return AuthenticationStatus.SUCCESS;
        } else {
            return AuthenticationStatus.FAILURE;
        }
    }
}