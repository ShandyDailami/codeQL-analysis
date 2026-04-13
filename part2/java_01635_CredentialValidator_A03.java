public class java_01635_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_01635_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValidUsername() {
        // This is a dummy operation. In a real-world application, this would be
        // a call to a database or other external source of credentials.
        return username != null && !username.isEmpty();
    }

    public boolean isValidPassword() {
        // This is a dummy operation. In a real-world application, this would be
        // a call to a database or other external source of credentials.
        return password != null && !password.isEmpty();
    }

    public boolean isValidCredentials() {
        return isValidUsername() && isValidPassword();
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("username", "password");
        System.out.println(validator.isValidCredentials());  // Output: true
    }
}