public class java_37939_CredentialValidator_A07 {

    private String pattern;

    public java_37939_CredentialValidator_A07(String pattern) {
        this.pattern = pattern;
    }

    public boolean isValid(String password) {
        return password.matches(this.pattern);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
        System.out.println(validator.isValid("Password@123")); // returns true
        System.out.println(validator.isValid("password")); // returns false
    }
}