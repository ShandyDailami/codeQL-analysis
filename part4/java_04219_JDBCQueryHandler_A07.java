import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_04219_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            // Example: Checking if a user exists in the database
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "exampleUser"); // replace with the actual username

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("User exists");
            } else {
                System.out.println("User does not exist");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}