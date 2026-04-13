import java.sql.*;

public class java_00189_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, "testUser"); // This is where we insert the username into the query

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String username = result.getString("username");
                System.out.println("User found: " + username);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}