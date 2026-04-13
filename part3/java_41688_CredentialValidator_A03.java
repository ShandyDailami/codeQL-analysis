public class java_41688_CredentialValidator_A03 {

    public static void main(String[] args) {
        String password = "password";
        validatePassword(password);
    }

    public static void validatePassword(String password) {
        String[] suspiciousWords = {"badPassword", "password123", "passwordForgotten"};

        for (String word : suspiciousWords) {
            if (password.contains(word)) {
                System.out.println("Password contains suspicious word: " + word);
                return;
            }
        }

        System.out.println("Password is valid.");
    }
}