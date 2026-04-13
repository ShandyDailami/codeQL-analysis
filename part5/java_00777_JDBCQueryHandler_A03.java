import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_00777_JDBCQueryHandler_A03 {

    // This method connects to the database and executes a query.
    public void executeQuery(String url, String username, String password, String query) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            conn = DriverManager.getConnection(url, username, password);

            // Prepare the statement
            pstmt = conn.prepareStatement(query);

            // Execute the query
            rs = pstmt.executeQuery();

            // Handle the result set
            while (rs.next()) {
                // You can use rs.getString(columnName), rs.getInt(columnName), etc.
                // to retrieve the data.
                System.out.println("Data: " + rs.getString("columnName"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Don't forget to close the resources!
            try { if(rs != null) rs.close(); } catch(SQLException e) {}
            try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
            try { if(conn != null) conn.close(); } catch(SQLException e) {}
        }
    }
}