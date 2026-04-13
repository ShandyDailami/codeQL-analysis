import java.sql.*;

public class java_25908_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_25908_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
        statement.close();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public static void main(String[] args) {
        // Provide your own database URL, username, and password
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "myuser", "mypassword");

            // Example: Updating a record
            handler.executeUpdate("UPDATE my_table SET column1 = 'new_value' WHERE condition");

            // Example: Fetching records
            ResultSet result = handler.executeQuery("SELECT * FROM my_table");
            while (result.next()) {
                System.out.println("Found record: " + result.getString("column1"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}