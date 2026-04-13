public class java_36798_CredentialValidator_A01 implements CredentialValidator {

    private HashMap<String, String> credentialMap;

    public java_36798_CredentialValidator_A01() {
        this.credentialMap = new HashMap<>();
        this.credentialMap.put("admin", "password"); // Add some dummy credentials
    }

    @Override
    public UsernamePasswordCredentials validate(UsernamePasswordCredentials credentials) throws CredentialException {
        String user = credentials.getUsername();
        String password = credentials.getPassword();

        // If the user is in our map and their password matches, return the credentials
        if (this.credentialMap.containsKey(user) && this.credentialMap.get(user).equals(password)) {
            return credentials;
        }

        // If they're not, throw a CredentialException
        throw new CredentialException("Invalid username or password");
    }
}