public class java_33626_CredentialValidator_A08 {

    public boolean validate(String username, String password) {
        // This is a placeholder, replace with actual logic
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        if (validator.validate("admin", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}