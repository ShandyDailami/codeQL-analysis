import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_22134_JDBCQueryHandler_A07 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/mydb";

    // Database credentials
    private static final String USER = "user";
    private static final String PASS = "password";

    public java_22134_JDBCQueryHandler_A07() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // This method retrieves the user's information
    public String retrieveUserInfo(String userID) {
        String userInfo = "";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String SQL = "SELECT * FROM USERS WHERE ID = ?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                userInfo = rs.getString("username");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statements and connections
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return userInfo;
    }

}