public class java_37897_CredentialValidator_A01 implements CredentialValidator {

    // A set of pre-defined users and passwords
    private static final Map<String, String> preDefinedUsers = new HashMap<>();
    static {
        preDefinedUsers.put("user1", "password1");
        preDefinedUsers.put("user2", "password2");
        // and so on...
    }

    @Override
    public boolean validate(String username, String password) {
        // Check if the username and password are in the pre-defined set
        return preDefinedUsers.containsKey(username) && preDefinedUsers.get(username).equals(password);
    }
}