import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_41322_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password = "password";

            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, "user1");
            statement.setString(2, "password1");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println("User found!");
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}