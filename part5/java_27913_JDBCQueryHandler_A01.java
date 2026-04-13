import java.sql.*;

public class java_27913_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_27913_JDBCQueryHandler_A01(String dbUrl, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");

            String query = "SELECT * FROM users WHERE email = ?";
            PreparedStatement preparedStatement = jdbcQueryHandler.connection.prepareStatement(query);
            preparedStatement.setString(1, "test@example.com");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                System.out.println("Email: " + email + ", Password: " + password);
            }

            jdbcQueryHandler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}