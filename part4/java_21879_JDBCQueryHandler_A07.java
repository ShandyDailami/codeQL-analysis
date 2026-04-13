import java.sql.*;

public class java_21879_JDBCQueryHandler_A07 {

    private static final String DB_URL = "your_db_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private Connection connection;

    public java_21879_JDBCQueryHandler_A07() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to establish connection: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // process each row of the result set
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close connection: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler();
    }
}