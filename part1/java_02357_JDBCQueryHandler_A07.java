import java.sql.*;

public class java_02357_JDBCQueryHandler_A07 {

    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";
    private static final String URL = "jdbc:your_database_url";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM your_table"));
                while (resultSet.next()) {
                    // handle your data here
                }
                resultSet.close();
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to database: " + e.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}