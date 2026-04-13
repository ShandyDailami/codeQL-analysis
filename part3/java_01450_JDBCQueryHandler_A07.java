import java.sql.*;

public class java_01450_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "myuser";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "username");
            statement.setString(2, "password");

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("Authenticated successfully.");
            } else {
                System.out.println("Authentication failed.");
            }

            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}