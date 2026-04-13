import java.sql.*;

public class java_17662_JDBCQueryHandler_A07 {

    private Connection connection;

    public java_17662_JDBCQueryHandler_A07(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
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
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test_db", "username", "password");
            ResultSet resultSet = handler.executeQuery("SELECT * FROM users WHERE username = 'test'");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            handler.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}