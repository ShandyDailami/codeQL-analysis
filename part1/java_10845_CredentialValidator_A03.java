public class java_10845_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_10845_CredentialValidator_A03(String username, String password) {
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

public class CredentialValidator {
    public boolean isValid(Credential credential) {
        // For simplicity, we'll just check if the username and password are not empty
        // In a real application, you would likely have a method to retrieve the credentials
        // from a database or other storage mechanism.
        return !(credential.getUsername().isEmpty() || credential.getPassword().isEmpty());
    }
}

public class Main {
    public static void main(String[] args) {
        Credential credential = new Credential("user", "password");
        CredentialValidator validator = new CredentialValidator();

        if (validator.isValid(credential)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}