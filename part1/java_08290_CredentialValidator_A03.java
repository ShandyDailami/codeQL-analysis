public class java_08290_CredentialValidator_A03 {

    // Step 1: Create a Credential object
    private Credential credential;

    public java_08290_CredentialValidator_A03(Credential credential) {
        this.credential = credential;
    }

    // Step 2: Implement the checkUser method
    public boolean checkUser() {
        // Step 3: Use the standard library's hash function to hash the password
        String hashedPassword = DigestUtils.sha256Hex(this.credential.getPassword());

        // Step 4: Compare the hashed password with the stored one
        if (hashedPassword.equals(this.credential.getStoredPassword())) {
            return true;
        } else {
            return false;
        }
    }
}

public class Credential {
    private String password;
    private String storedPassword;

    public java_08290_CredentialValidator_A03(String password, String storedPassword) {
        this.password = password;
        this.storedPassword = storedPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getStoredPassword() {
        return storedPassword;
    }
}