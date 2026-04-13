public class java_31520_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_31520_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Credential that = (Credential) obj;
        return (username.equals(that.username) && password.equals(that.password));
    }
}

public class Main {
    public static void main(String[] args) {
        Credential validator = new Credential("admin", "password");

        // This is a dummy Credential with invalid credentials.
        Credential invalidCredential = new Credential("invalidUser", "invalidPassword");

        if (validator.equals(invalidCredential)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}