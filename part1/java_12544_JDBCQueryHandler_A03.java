import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12544_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:placeholder"; // Replace with your actual database URL
        String username = "placeholder"; // Replace with your actual username
        String password = "placeholder"; // Replace with your actual password

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}