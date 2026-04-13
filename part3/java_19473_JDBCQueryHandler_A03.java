import java.sql.*;

public class java_19473_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE name = ?";
        String name = "John";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.prepareStatement(query);
            statement.setString(1, name);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String username = result.getString("name");
                System.out.println("Username: " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}