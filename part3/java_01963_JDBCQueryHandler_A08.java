import java.sql.*;

public class java_01963_JDBCQueryHandler_A08 {

    // In a real-world application, these should be parameters to a configuration class
    private static final String url = "jdbc:mysql://localhost:3306/dbname";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            connectToDatabase();
        } catch (SQLException e) {
            System.out.println("Connection failed, please try again later.");
            e.printStackTrace();
        }
    }

    private static void connectToDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        // Here we assume that the database has a table named 'users' and it has columns named 'username' and 'password'
        String query = "SELECT * FROM users WHERE username = 'test' AND password = 'test'";
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }

        // Always close your connections
        resultSet.close();
        statement.close();
        connection.close();
    }
}