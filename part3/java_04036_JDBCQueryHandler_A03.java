import java.sql.*;

public class java_04036_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_04036_JDBCQueryHandler_A03() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        String query = "SELECT * FROM users WHERE username = ?";
        ResultSet result = handler.executeQuery(query);

        try {
            while (result.next()) {
                String username = result.getString("username");
                // Do something with the username
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}