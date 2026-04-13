import java.sql.*;

public class java_09132_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_09132_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

            // Example: Fetch all records from the table 'Employees'
            String query = "SELECT * FROM Employees";
            ResultSet result = handler.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                // ... handle the result set further
            }

            // Example: Insert a new record into the 'Employees' table
            String insertQuery = "INSERT INTO Employees (name) VALUES ('John Doe')";
            handler.executeUpdate(insertQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}