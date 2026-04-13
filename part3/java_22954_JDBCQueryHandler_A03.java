import java.sql.*;

public class java_22954_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_22954_JDBCQueryHandler_A03() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void executeQuery(String query, String parameter) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query + parameter);
            while (resultSet.next()) {
                // Handle result set here
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        String query = "SELECT * FROM users WHERE username = ";
        String parameter = "'badUser'"; // This is a bad practice, but we're using it here for demonstration
        handler.executeQuery(query, parameter);
    }
}