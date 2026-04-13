public class java_03612_CredentialValidator_A03 implements CredentialValidator {

    private HashMap<String, String> credentials;

    public java_03612_CredentialValidator_A03() {
        // Loading credentials from a database or another external source
        credentials = new HashMap<String, String>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && 
            credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

}