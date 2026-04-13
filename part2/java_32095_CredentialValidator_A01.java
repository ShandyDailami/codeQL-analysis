public class java_32095_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_32095_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // Stub method, this should be replaced with actual validation logic
        // for example, you can check if the username is "admin" and the password is "password"
        // for security reasons, you should not store or hash passwords in plain text
        if ("admin".equals(this.username) && "password".equals(this.password)) {
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.validate()) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}