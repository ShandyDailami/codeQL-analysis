public class java_21149_CredentialValidator_A01 implements CredentialValidator {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(CustomCredentialValidator.class);

    private static final String USER_ROLE = "user";
    private static final String ADMIN_ROLE = "admin";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws InvalidCredentialsException {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        // Fictitious operation related to user's roles
        if (username.equals("admin")) {
            setAdminRole(password);
            return true;
        }

        if (username.equals("user")) {
            setUserRole(password);
            return true;
        }

        logger.warning("Username not recognized: " + username);
        throw new InvalidCredentialsException("Username not recognized");
    }

    private void setAdminRole(String password) {
        // Sensitive operation related to Admin Role, e.g., role-based access control
        // For now, let's assume that the password is enough for the access control
        if (password.equals("adminPassword")) {
            logger.info("Access granted to admin role");
            // Here, you can add more security-sensitive operations related to the admin role
        } else {
            logger.warning("Incorrect password for admin role");
            throw new InvalidCredentialsException("Incorrect password for admin role");
        }
    }

    private void setUserRole(String password) {
        // Sensitive operation related to User Role, e.g., role-based access control
        // For now, let's assume that the password is enough for the access control
        if (password.equals("userPassword")) {
            logger.info("Access granted to user role");
            // Here, you can add more security-sensitive operations related to the user role
        } else {
            logger.warning("Incorrect password for user role");
            throw new InvalidCredentialsException("Incorrect password for user role");
        }
    }
}