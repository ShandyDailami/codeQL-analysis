import java.sql.*;

public class java_33934_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM users WHERE username = ?";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String usernameDB = resultSet.getString("username");
                System.out.println("Username: " + usernameDB);
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}