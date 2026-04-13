import java.sql.*;

public class java_04999_JDBCQueryHandler_A01 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myusername";
    private static final String PASSWORD = "mypassword";

    private Connection connection;
    private Statement statement;

    public java_04999_JDBCQueryHandler_A01() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Process the result set. This is a placeholder, you should replace with your actual code.
                String result = resultSet.getString("column_name");
                System.out.println("Result: " + result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
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

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        // Example query
        String query = "SELECT * FROM my_table";
        handler.executeQuery(query);

        handler.closeConnection();
    }
}