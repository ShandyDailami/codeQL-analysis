import java.util.Scanner;

public class java_27144_CredentialValidator_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        PasswordValidator validator = new PasswordValidator();
        validator.setPassword(password);

        if (validator.isValid()) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }
}

class PasswordValidator {
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid() {
        return password != null && password.length() > 8;
    }
}