import java.util.Arrays;

public class java_30084_CredentialValidator_A07 {

    private static final String[] USERS = {"user1", "user2", "user3"};
    private static final String[] PASSWORDS = {"pass1", "pass2", "pass3"};

    public static boolean isValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        int userIndex = Arrays.asList(USERS).indexOf(username);

        if (userIndex == -1 || !PASSWORDS[userIndex].equals(password)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("user1", "pass1")); // should print true
        System.out.println(isValid("user1", "wrongPass")); // should print false
        System.out.println(isValid("nonExistentUser", "nonExistentPass")); // should print false
    }
}