public class java_32036_CredentialValidator_A03 {

    // predefined set of credentials
    private static final Map<String, String> credentials = new HashMap<>();

    // initialize the set of credentials
    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // validate a username and password
    public static boolean validate(String username, String password) {
        // check if the username and password are in the set
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }
}