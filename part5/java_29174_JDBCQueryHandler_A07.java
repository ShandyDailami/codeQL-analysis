import java.sql.*;

public class java_29174_JDBCQueryHandler_A07 {

    // Connection
    private static Connection connection = null;

    // Driver and URL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Driver
    static {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Execute Query
    public static ResultSet executeQuery(String query) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
        ResultSet resultSet = executeQuery(query);
        try {
            if (resultSet.next()) {
                System.out.println("Successfully authenticated!");
            } else {
                System.out.println("Authentication failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}