public class java_20378_CredentialValidator_A07 {

    // Assume we have a Database object that stores the credentials.
    private Database database;

    public java_20378_CredentialValidator_A07() {
        database = new Database();
    }

    public boolean validateCredentials(String username, String password) {
        // Step 1: Fetch the credentials from the database.
        Credential credential = database.fetchCredential(username);

        // Step 2: Validate the password.
        if (credential != null && credential.getPassword().equals(password)) {
            // If the passwords match, return true.
            return true;
        } else {
            // If the passwords don't match, return false.
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean valid = validator.validateCredentials("user", "password");
        System.out.println("Is valid: " + valid);
    }
}

class Database {
    private Map<String, Credential> credentials = new HashMap<>();

    public java_20378_CredentialValidator_A07() {
        // Initialize the credentials.
        credentials.put("user", new Credential("user", "password"));
    }

    public Credential fetchCredential(String username) {
        return credentials.get(username);
    }
}

class Credential {
    private String username;
    private String password;

    public java_20378_CredentialValidator_A07(String username, String password) {
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