public class java_40108_CredentialValidator_A08 {
    // Define two fields for the username and password
    private String username;
    private String password;

    // Constructor
    public java_40108_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Override the equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CredentialValidator that = (CredentialValidator) obj;
        return username.equals(that.username) && password.equals(that.password);
    }

    // Override the hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}