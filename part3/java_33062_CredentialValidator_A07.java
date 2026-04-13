public class java_33062_CredentialValidator_A07 {
    private static final String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public static boolean validate(String password) {
        return password.matches(PATTERN);
    }

    public static void main(String[] args) {
        String password1 = "password123";
        String password2 = "password";

        System.out.println(validate(password1)); // true
        System.out.println(validate(password2)); // false
    }
}