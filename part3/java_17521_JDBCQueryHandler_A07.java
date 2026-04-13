import java.sql.*;

public class java_17521_JDBCQueryHandler_A07 {

    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            handleAuthenticationFailure();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void handleAuthenticationFailure() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        String query = "SELECT * FROM Users WHERE username = 'bad_user' AND password = 'bad_password'";
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            System.out.println("Authentication failed. User not found.");
        } else {
            System.out.println("Authentication succeeded. User found.");
        }

        connection.close();
    }
}