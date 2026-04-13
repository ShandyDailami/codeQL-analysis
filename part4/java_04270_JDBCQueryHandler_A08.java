import java.sql.*;

public class java_04270_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM Users WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, 123); // This is a dummy value for demonstration purposes

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String email = resultSet.getString("Email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}