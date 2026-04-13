import java.util.Base64;

public class java_07303_CredentialValidator_A08 {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    public static class Credential {
        private String username;
        private String password;

        public java_07303_CredentialValidator_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public boolean validate(Credential credential) {
        return credential.getUsername().equals(USERNAME) &&
                credential.getPassword().equals(hashPassword(credential.getPassword()));
    }

    private String hashPassword(String password) {
        byte[] hashedPassword = hashPassword(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    private byte[] hashPassword(byte[] password) {
        // Simple hash function for demonstration purposes
        int hash = 0;
        for (byte b : password) {
            hash += b;
        }
        return new byte[]{(byte) hash};
    }
}