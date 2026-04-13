public class java_08122_CredentialValidator_A03 {
    public static boolean validate(String username, String password) {
        if (username == null || username.length() == 0) {
            return false;
        }

        if (password == null || password.length() == 0) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        for (char c : username.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validate("alice", "alice123!")); // Should print true
        System.out.println(validate("alice", "123")); // Should print false
        System.out.println(validate("alice", "")); // Should print false
        System.out.println(validate("", "")); // Should print false
    }
}