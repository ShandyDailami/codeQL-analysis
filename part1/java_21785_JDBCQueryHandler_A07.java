import java.sql.*;

public class java_21785_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String USER = "your-username";
    private static final String PASS = "your-password";

    // SQL queries
    private static final String SQL_SELECT = "SELECT * FROM users";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Don't forget to close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://your-hostname/dbname", USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return connection;
    }
}