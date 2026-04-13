import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_35155_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            // Execute your SQL Query here
            String query = "SELECT * FROM mytable";
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }
}