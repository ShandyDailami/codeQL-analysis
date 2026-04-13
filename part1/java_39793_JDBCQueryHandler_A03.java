import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_39793_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Step 1: Load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Connect to MySQL Database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password")) {

            // Step 3: Prepare the SQL Query
            String sql = "SELECT * FROM my_table WHERE my_column = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "some_value");

            // Step 4: Execute the SQL Query
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Process the ResultSet
            while (rs.next()) {
                String value = rs.getString("my_column");
                System.out.println("Value: " + value);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}