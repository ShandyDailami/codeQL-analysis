import java.sql.*;

public class java_13733_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            connectDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void connectDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String query = "SELECT * FROM users WHERE username = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "valid_user");
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            System.out.println("User found: " + result.getString("username"));
        }

        connection.close();
    }
}