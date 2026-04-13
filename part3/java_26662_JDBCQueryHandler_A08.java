import java.sql.*;

public class java_26662_JDBCQueryHandler_A08 {
    private Connection connection;
    private Statement statement;

    public java_26662_JDBCQueryHandler_A08(String dbURL, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, userName, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "password");
            ResultSet resultSet = handler.executeQuery("SELECT * FROM users WHERE role = 'admin'");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                System.out.println("Username: " + username);
                System.out.println("Role: " + role);
            }

            handler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}