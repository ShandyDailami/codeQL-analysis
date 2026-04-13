import java.sql.*;

public class java_25784_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM Users WHERE Username = 'user' AND Password = 'pass'";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    String username = resultSet.getString("Username");
                    String password = resultSet.getString("Password");
                    System.out.println("Username: " + username + ", Password: " + password);
                }
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}