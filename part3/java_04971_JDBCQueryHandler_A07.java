import java.sql.*;

public class java_04971_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();

            // Example of a security-sensitive operation related to authentication failure
            String sql = "SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println("Successfully authenticated!");
            } else {
                System.out.println("Authentication failed!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}