public class java_06965_CredentialValidator_A07 {

    private static final Map<String, String> knownUsers = new HashMap<>();

    static {
        knownUsers.put("user1", "password1");
        knownUsers.put("user2", "password2");
        knownUsers.put("user3", "password3");
    }

    public static boolean validate(String username, String password) {
        String expectedPassword = knownUsers.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }

}