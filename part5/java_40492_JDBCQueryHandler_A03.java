import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_40492_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Open a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // 3. Create a statement
            pstmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");

            // 4. Set the parameter and execute the statement
            pstmt.setInt(1, 123);  // The id of the user to fetch
            pstmt.executeUpdate();

            // 5. Process the result set
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 6. Close the statement and connection
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }
}