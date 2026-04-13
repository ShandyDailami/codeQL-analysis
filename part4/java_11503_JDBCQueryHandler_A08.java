import java.sql.*;

public class java_11503_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            // Insert
            String insertQuery = "INSERT INTO Users (id, username, password) VALUES (1, 'admin', 'password')";
            statement.executeUpdate(insertQuery);

            // Select
            String selectQuery = "SELECT password FROM Users WHERE username = 'admin'";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            if (resultSet.next()) {
                String password = resultSet.getString("password");
                System.out.println("Password: " + password);
            }

            // Update
            String updateQuery = "UPDATE Users SET password = 'newpassword' WHERE username = 'admin'";
            statement.executeUpdate(updateQuery);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return connection;
    }
}