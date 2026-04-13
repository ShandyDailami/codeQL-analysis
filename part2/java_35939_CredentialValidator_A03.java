public class java_35939_CredentialValidator_A03 {
    private DatabaseService databaseService;

    // constructor
    public java_35939_CredentialValidator_A03(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public boolean validateCredentials(String username, String password) {
        // assume the database service will check the credentials
        boolean isValid = databaseService.checkCredentials(username, password);
        if (isValid) {
            System.out.println("Credentials validated successfully.");
        } else {
            System.out.println("Invalid credentials.");
        }
        return isValid;
    }
}

public class DatabaseService {
    public boolean checkCredentials(String username, String password) {
        // mock method to check credentials
        // in real world, this would be a query to a database
        // we're going to simulate a database by returning hardcoded results
        return username.equals("admin") && password.equals("password");
    }
}

// usage
public class Main {
    public static void main(String[] args) {
        // create the database service
        DatabaseService databaseService = new DatabaseService();

        // create the credential validator
        CredentialValidator validator = new CredentialValidator(databaseService);

        // use the validator to validate the credentials
        validator.validateCredentials("admin", "password");
    }
}