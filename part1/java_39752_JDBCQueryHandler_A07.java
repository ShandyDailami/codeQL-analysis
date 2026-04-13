import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_39752_JDBCQueryHandler_A07 {

    private Connection conn;

    public java_39752_JDBCQueryHandler_A07() {
        String url = "jdbc:mysql://localhost:3306/db_name";
        String username = "username";
        String password = "password";

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            // Create a PreparedStatement
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Process the result
            while (rs.next()) {
                System.out.println(rs.getString("columnName"));
            }

            // Close the ResultSet and the PreparedStatement
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            // Close the connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}