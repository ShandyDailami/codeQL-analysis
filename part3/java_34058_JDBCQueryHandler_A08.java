import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_34058_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        try {
            //Step 1: Load the Database Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Step 2: Establish a Connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/testdb?useSSL=false", "username", "password");

            //Step 3: Create a SQL Query
            String sql = "INSERT INTO users(username, password) VALUES (?, ?)";

            //Step 4: Prepare the Statement
            PreparedStatement statement = connection.prepareStatement(sql);

            //Step 5: Bind the Parameters
            statement.setString(1, "user1");
            statement.setString(2, "password1");

            //Step 6: Execute the Statement
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Affected rows: " + affectedRows);
            } else {
                System.out.println("No rows affected.");
            }

            //Step 7: Close the Connection
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}