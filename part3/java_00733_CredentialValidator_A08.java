import java.util.regex.Pattern;

public class java_00733_CredentialValidator_A08 {

    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        if (!(password.length() >= 8)) {
            return false;
        }

        if (!(password.matches(".*[A-Z].*"))) {
            return false;
        }

        if (!(password.matches(".*[a-z].*"))) {
            return false;
        }

        if (!(password.matches(".*[0-9].*"))) {
            return false;
        }

        if (!(password.matches(".*[#|$|&|*?^].*"))) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String password = "strongPassword@123";
        if (validator.validatePassword(password)) {
            System.out.println("Password is strong");
        } else {
            System.out.println("Password is weak");
        }
    }
}