// Define Credential
public class java_00018_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_00018_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

// Define CredentialValidator
public class CredentialValidator {
    private Credential storedCredential;

    public java_00018_CredentialValidator_A08() {
        storedCredential = new Credential("admin", "password"); // Stored Credential
    }

    // Method to validate the entered credentials
    public boolean validate(String username, String password) {
        if(username.equals(storedCredential.getUsername()) && password.equals(storedCredential.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}

// Test CredentialValidator
public class Main {
    public static void main(String[] args) {
        CredentialValidator credentialValidator = new CredentialValidator();

        System.out.println("Enter Username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();

        System.out.println("Enter Password:");
        String password = scanner.next();

        boolean isValid = credentialValidator.validate(username, password);

        if(isValid) {
            System.out.println("Credentials Valid!");
        } else {
            System.out.println("Invalid Credentials!");
        }
    }
}