public class java_17619_CredentialValidator_A03 {
    private static final String[] SECURE_PASSWORDS = {"password1", "123456", "passwordl"};

    public static boolean validate(String password) {
        for (String securePassword : SECURE_PASSWORDS) {
            if (securePassword.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the validator
        System.out.println(validate("password1") ? "Valid" : "Invalid"); // Should print "Valid"
        System.out.println(validate("incorrectPassword") ? "Valid" : "Invalid"); // Should print "Invalid"
    }
}