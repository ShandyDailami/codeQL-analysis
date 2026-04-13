import java.sql.*;

public class java_37720_JDBCQueryHandler_A07 {
    private static final String USERNAME = "db_username";
    private static final String PASSWORD = "db_password";
    private static final String URL = "jdbc:mysql://db_host:db_port/db_name";

    public static void main(String[] args) {
        try {
            executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeQuery() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}