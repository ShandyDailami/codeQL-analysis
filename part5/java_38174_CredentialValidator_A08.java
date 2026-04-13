public class java_38174_CredentialValidator_A08 {

    private static final String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,16}$";

    public boolean isValid(String password) {
        return password.matches(PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.isValid("password"));  // false
        System.out.println(validator.isValid("password1"));  // false
        System.out.println(validator.isValid("Password@123"));  // false
        System.out.println(validator.isValid("Password@1234"));  // true
    }
}