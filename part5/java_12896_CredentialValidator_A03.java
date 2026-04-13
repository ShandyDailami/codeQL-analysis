public class java_12896_CredentialValidator_A03 {

    // CredentialValidator class does not use external frameworks
    // but we can still use the java.util.regex package for password validation
    // This is done in the validate method

    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Here, we're checking if the password length is more than 8 characters
        // You can adjust the length check based on your requirements
        if (password.length() <= 8) {
            System.out.println("Password length must be more than 8 characters");
            return false;
        }

        // Here, we're using regular expressions to check if the password contains any special characters
        // In a real-world application, you would use a more complex password validation method
        // This is done in the next line of code
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])(?=\\S+$)")) {
            System.out.println("Password must contain at least one number, one lowercase, one uppercase, and one special character");
            return false;
        }

        System.out.println("Password is valid");
        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("StrongPassword123"); // This should print "Password is valid"
        validator.validate("WeakPassword"); // This should print "Password length must be more than 8 characters"
    }
}