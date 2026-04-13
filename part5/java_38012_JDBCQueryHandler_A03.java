import java.sql.*;

public class java_38012_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM Users WHERE Username = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Setting parameter value
            statement.setString(1, "admin");

            // Executing query
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String usernameFromDb = resultSet.getString("Username");
                String passwordFromDb = resultSet.getString("Password");
                System.out.println("Username: " + usernameFromDb);
                System.out.println("Password: " + passwordFromDb);
            }

            // closing the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}