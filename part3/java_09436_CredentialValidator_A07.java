import java.util.Arrays;
import java.util.List;

public class java_09436_CredentialValidator_A07 {

    private List<String> acceptedPasswords = Arrays.asList("password1", "password2", "password3");

    public boolean validate(String password) {
        return acceptedPasswords.contains(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String password = "password1";
        if(validator.validate(password)) {
            System.out.println("Access granted for password: " + password);
        } else {
            System.out.println("Access denied for password: " + password);
        }
    }
}