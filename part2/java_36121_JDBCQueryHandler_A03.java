import java.sql.*;

public class java_36121_JDBCQueryHandler_A03 {

    // PreparedStatement for security-sensitive operations
    private PreparedStatement preparedStatement;

    public java_36121_JDBCQueryHandler_A03(Connection connection, String query) throws SQLException {
        this.preparedStatement = connection.prepareStatement(query);
    }

    public void setParameter(int parameter, Object value) throws SQLException {
        this.preparedStatement.setObject(parameter, value);
    }

    public ResultSet executeQuery() throws SQLException {
        return this.preparedStatement.executeQuery();
    }

    public void close() throws SQLException {
        this.preparedStatement.close();
    }

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "username", "password");
            String query = "SELECT * FROM users WHERE email = ?";
            JDBCQueryHandler handler = new JDBCQueryHandler(connection, query);
            handler.setParameter(1, "test@example.com");
            ResultSet result = handler.executeQuery();
            while (result.next()) {
                String email = result.getString("email");
                System.out.println("Email: " + email);
            }
            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}