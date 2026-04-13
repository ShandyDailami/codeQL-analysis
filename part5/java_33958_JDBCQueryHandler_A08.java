import java.sql.*;

public class java_33958_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_33958_JDBCQueryHandler_A08(String url, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Process the result set here
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Replace the placeholders with your actual values
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");
        handler.executeQuery("SELECT * FROM your_table");
    }
}