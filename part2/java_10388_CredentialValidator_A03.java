import java.util.Scanner;

public class java_10388_CredentialValidator_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        CredentialValidator validator = new CredentialValidator(password);
        if (validator.isValid()) {
            System.out.println("Password is valid!");
        } else {
            System.out.println("Password is not valid!");
        }
    }
}

class CredentialValidator {
    private String password;

    public java_10388_CredentialValidator_A03(String password) {
        this.password = password;
    }

    public boolean isValid() {
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        return true;
    }
}