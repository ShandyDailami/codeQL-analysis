import java.sql.*;

public class java_14976_JDBCQueryHandler_A01 {

    public static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();

            // Example query 1
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE role = 'admin'");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            // Example query 2
            statement.executeUpdate("UPDATE Users SET role = 'user' WHERE username = 'admin'");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}