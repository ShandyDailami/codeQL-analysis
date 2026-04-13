import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_27675_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            String sql = "SELECT * FROM mytable WHERE column1 = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Step 4: Set the parameter
            statement.setString(1, "value1");

            // Step 5: Execute the statement
            ResultSet resultSet = statement.executeQuery();

            // Step 6: Process the result set
            while (resultSet.next()) {
                String column1Value = resultSet.getString("column1");
                System.out.println("Column 1 value: " + column1Value);
            }

            // Step 7: Close the statement and connection
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}