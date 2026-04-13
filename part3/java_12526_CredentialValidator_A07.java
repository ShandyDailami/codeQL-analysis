public class java_12526_CredentialValidator_A07 {
    private static final String[][] users = {
        { "user1", "password1" },
        { "user2", "password2" },
        { "user3", "password3" }
    };

    public static boolean validate(String username, String password) {
        for (String[] user : users) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("user1", "password1")); // true
        System.out.println(validate("user4", "password4")); // false
    }
}