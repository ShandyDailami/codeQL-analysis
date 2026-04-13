import java.sql.*;

public class java_06648_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_db_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private Connection connection;

    public java_06648_JDBCQueryHandler_A07() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        // Example of executing a SELECT query
        String query = "SELECT * FROM users WHERE email = ?";
        ResultSet result = handler.executeQuery(query);
        while (result.next()) {
            String email = result.getString("email");
            System.out.println("Email: " + email);
        }

        // Example of executing an UPDATE query with a parameterized query
        String updateQuery = "UPDATE users SET password = ? WHERE email = ?";
        handler.executeUpdate(updateQuery);

        connection.close();
    }
}