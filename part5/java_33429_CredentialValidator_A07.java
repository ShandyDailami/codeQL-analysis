public class java_33429_CredentialValidator_A07 implements CredentialValidator {

    private static final String SALT = "A07_AuthFailure";

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException {
        String password = credential.getPasswordAsString();
        String encodedPassword = passwordToEncodedSHA256(password);

        // Fetching the encoded password from the database
        String dbEncodedPassword = getPasswordFromDatabase(credential.getUsername());

        if (encodedPassword.equals(dbEncodedPassword)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid password or username");
        }
    }

    private String passwordToEncodedSHA256(String password) {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        // Add password bytes to digest
        digest.update(password.getBytes(StandardCharsets.UTF_8));
        // Get the hash's bytes 
        byte[] bytes = digest.digest();

        // Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    private String getPasswordFromDatabase(String username) {
        // Fetch the password from the database using username
        // For the purpose of this example, a dummy password is returned
        return passwordToEncodedSHA256(username + SALT);
    }
}