import java.sql.*;

public class java_33872_JDBCQueryHandler_A01 {

    // BrokenAccessControl is assumed to be a class and method
    public static void brokenAccessControl(Connection connection) {
        try {
            // This operation is broken due to lack of security measures
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
            
            while (resultSet.next()) {
                // Do something with the result set
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // Establish connection
            Connection connection = DriverManager.getConnection("jdbc:your_db_url", "username", "password");

            brokenAccessControl(connection);

            // Close connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}