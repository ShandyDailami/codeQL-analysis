public class java_33013_CredentialValidator_A01 {
    // A simple boolean to represent a valid/invalid credential state.
    private boolean isValid;

    public java_33013_CredentialValidator_A01(String username, String password) {
        // Simulate a validation process with a hard-coded username and password.
        this.isValid = username.equals("admin") && password.equals("password");
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setValid(boolean valid) {
        this.isValid = valid;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.isValid()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}