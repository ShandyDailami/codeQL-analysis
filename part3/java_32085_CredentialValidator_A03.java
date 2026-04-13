public class java_32085_CredentialValidator_A03 {
    private String password;

    public java_32085_CredentialValidator_A03(String password) throws IllegalArgumentException {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password should not be null and should contain at least 8 characters");
        }
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public static void main(String[] args) {
        try {
            CredentialValidator validator = new CredentialValidator("password");
            System.out.println("Password: " + validator.getPassword());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}