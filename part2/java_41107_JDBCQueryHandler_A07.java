import java.sql.*;

public class java_41107_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/db_name";
    private static final String username = "user";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT password FROM users WHERE username = '" + username + "'");

            if (resultSet.next()) {
                String password = resultSet.getString("password");
                System.out.println("Password: " + password);
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}