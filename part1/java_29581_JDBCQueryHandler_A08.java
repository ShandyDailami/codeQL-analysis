import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_29581_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");

            // Prepare the SQL statement
            String sql = "UPDATE my_table SET my_column = ? WHERE my_condition = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the parameters
            pstmt.setString(1, "new value");
            pstmt.setInt(2, 1234);

            // Execute the query
            int affectedRows = pstmt.executeUpdate();

            // Print the number of affected rows
            System.out.println("Affected rows: " + affectedRows);

            // Close the connection
            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}