import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_19619_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Get a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Create a statement
            pstmt = conn.prepareStatement("SELECT * FROM mytable WHERE column1 = ?");
            pstmt.setString(1, "someValue"); // Here we are setting a parameter value

            // Step 4: Execute the statement
            rs = pstmt.executeQuery();

            // Step 5: Process the result
            while (rs.next()) {
                System.out.println(rs.getString("column1"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }
}