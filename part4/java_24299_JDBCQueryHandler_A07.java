import java.sql.*;

public class java_24299_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            authenticate("wrong_user", "wrong_password"); // Example of incorrect authentication
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void authenticate(String user, String password) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?");
            statement.setString(1, user);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}