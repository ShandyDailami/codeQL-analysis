import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_34523_JDBCQueryHandler_A03 {

    public void performQuery(String url, String username, String password) {
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare the SQL statement
            String sql = "SELECT * FROM Users WHERE role=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Step 4: Set the parameter
            statement.setString(1, "admin");

            // Step 5: Execute the statement
            statement.executeUpdate();

            // Step 6: Handle the result
            // ...

            // Step 7: Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.performQuery("jdbc:mysql://localhost:3306/test", "username", "password");
    }
}