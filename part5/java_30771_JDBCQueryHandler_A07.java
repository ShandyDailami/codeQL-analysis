import java.sql.*;

public class java_30771_JDBCQueryHandler_A07 {
    private Connection connection;
    private Statement statement;

    public java_30771_JDBCQueryHandler_A07(String dbUrl, String user, String password) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            connection = DriverManager.getConnection(dbUrl, user, password);
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticate(String username, String password) {
        try {
            // Prepare the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE Username = '" + username + "' AND Password = '" + password + "'");

            // Check if there is a result (user exists)
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

        boolean isAuthenticated = handler.authenticate("user", "password");

        System.out.println("Is authenticated: " + isAuthenticated);
    }
}