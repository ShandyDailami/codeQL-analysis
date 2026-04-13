public class java_22343_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_22343_CredentialValidator_A08(String username, String password) {
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
    private Credential credential;

    public java_22343_CredentialValidator_A08(Credential credential) {
        this.credential = credential;
    }

    public boolean isValid(String username, String password) {
        if (username.equals(credential.getUsername()) && password.equals(credential.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Credential credential = new Credential("user", "password");
        CredentialValidator validator = new CredentialValidator(credential);

        if (validator.isValid("user", "password")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }
}