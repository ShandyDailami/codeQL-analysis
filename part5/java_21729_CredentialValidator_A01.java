public class java_21729_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_21729_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isStrongPassword() {
        if (password == null) {
            return false;
        }

        // We will consider a password to be strong enough if it contains a combination of at least one uppercase letter, one lowercase letter, one number and one special character.
        // We will also consider a password to be strong enough if it is at least 8 characters long.
        // This is a simple check and real security applications will require more rigorous checks.
        return (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*])[A-Za-z0-9@#$%^&*]{8,}$"));
    }
}