public class java_30655_CredentialValidator_A01 {
    private String encryptedPassword;

    public java_30655_CredentialValidator_A01(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public boolean isPasswordValid(String plainTextPassword) {
        String encryptedInput = encryptPassword(plainTextPassword);
        return encryptedInput.equals(this.encryptedPassword);
    }

    private String encryptPassword(String password) {
        // This is a simple example of a password encryption function. 
        // In a real-world application, you should use a more secure method.
        String encryptedPassword = "";
        for (char c : password.toCharArray()) {
            encryptedPassword += (char) (c + 1);
        }
        return encryptedPassword;
    }
}

// Test
public class Main {
    public static void main(String[] args) {
        String testPassword = "password";

        CredentialValidator validator = new CredentialValidator("encryptedPassword");

        if (validator.isPasswordValid(testPassword)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }
}