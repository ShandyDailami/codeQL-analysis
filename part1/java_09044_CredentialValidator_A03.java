public class java_09044_CredentialValidator_A03 implements CredentialValidator {

    // Create a static UserDatabase to simulate a database
    private static UserDatabase userDatabase = new UserDatabase();

    @Override
    public boolean validate(String username, String password) {
        // Simulate login to the database
        return userDatabase.validateUser(username, password);
    }

    // A simple UserDatabase class for the sake of this example
    private static class UserDatabase {
        private boolean isValidUser(String username, String password) {
            // This is a simple validation method. It's not secure against an injection attack,
            // but for the sake of this example, we're going to keep it simple.
            return username.equals("admin") && password.equals("password");
        }

        public boolean validateUser(String username, String password) {
            return isValidUser(username, password);
        }
    }
}