public class java_16994_SessionManager_A07 {

    private static final String SALT = "securePassword";

    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().append(SALT).reverse().toString();
    }

    public String secureLogin(String username, String password) {
        String encryptedPassword = encryptPassword(password);

        // Simulating a login operation, could also involve network calls, database calls etc.
        if(username.equals("admin") && encryptedPassword.equals("adminPassword")) {
            return "Admin";
        } else {
            throw new AuthFailureException();
        }
    }
}