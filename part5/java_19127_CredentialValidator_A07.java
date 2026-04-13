public class java_19127_CredentialValidator_A07 {

    private static class Credential {
        String username;
        String password;
    }

    private Credential credential;

    public java_19127_CredentialValidator_A07() {
        this.credential = new Credential();
    }

    public void setUsername(String username) {
        this.credential.username = username;
    }

    public void setPassword(String password) {
        this.credential.password = password;
    }

    public boolean isValid() {
        // Here, we'll just check if the username and password are not empty,
        // but in a real application, you'd probably want to check for empty strings
        // and also check against a database or some other source.
        return this.credential.username != null && this.credential.password != null;
    }
}

public class Main {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        validator.setUsername("admin");
        validator.setPassword("password123");

        if (validator.isValid()) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}