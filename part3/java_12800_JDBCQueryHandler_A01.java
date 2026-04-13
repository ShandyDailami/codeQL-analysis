import java.sql.*;

public class java_12800_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_12800_JDBCQueryHandler_A01(String dbURL, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, userName, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            // assuming the database URL, username, and password are hardcoded
            JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");

            ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("Name: " + name + ", Email: " + email);
            }

            jdbcQueryHandler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}