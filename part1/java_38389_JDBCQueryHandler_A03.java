import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_38389_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String selectQuery = "SELECT * FROM users WHERE username = ?";
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            try (java.sql.PreparedStatement statement = connection.prepareStatement(selectQuery)) {
                statement.setString(1, "admin");
                java.sql.ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    System.out.println("Username: " + resultSet.getString("username"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}