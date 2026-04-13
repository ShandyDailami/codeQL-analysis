import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_23838_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM users WHERE username = ?";

            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query, "admin");

                if (resultSet.next()) {
                    String passwordFromDB = resultSet.getString("password");
                    System.out.println("Password from database: " + passwordFromDB);
                } else {
                    System.out.println("No user found with the provided username");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}