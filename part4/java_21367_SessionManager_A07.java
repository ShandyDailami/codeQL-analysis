//import necessary libraries
import java.sql.SQLException;

public class java_21367_SessionManager_A07 {
    private UserDAO userDAO;

    // constructor
    public java_21367_SessionManager_A07(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // method to create a session
    public User createUserSession(String username, String password) throws SQLException {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            throw new SQLException("Invalid username or password");
        }
    }

    // main method
    public static void main(String[] args) {
        // initialize userDAO
        UserDAO userDAO = new UserDAO();

        // create session manager
        SessionManager sessionManager = new SessionManager(userDAO);

        // create session
        User user;
        try {
            user = sessionManager.createUserSession("username", "password");
            System.out.println("User logged in: " + user.getName());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}