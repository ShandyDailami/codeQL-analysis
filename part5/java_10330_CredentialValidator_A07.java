public class java_10330_CredentialValidator_A07 {

    // Predefined set of credentials
    private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // CredentialValidator class is marked as 'static' so it can be accessed directly
    // This is a security-sensitive operation related to A07_AuthFailure
    public static boolean validate(String username, String password) {
        return password.equals(credentials.getOrDefault(username, ""));
    }

    public static void main(String[] args) {
        System.out.println(validate("user1", "password1")); // true
        System.out.println(validate("user1", "wrong_password")); // false
        System.out.println(validate("unknown_user", "any_password")); // false
    }
}