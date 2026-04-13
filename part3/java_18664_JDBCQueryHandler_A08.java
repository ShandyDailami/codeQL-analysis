import java.sql.*;
import java.util.Properties;

public class java_18664_JDBCQueryHandler_A08 {
    private Connection conn;
    private PreparedStatement pstmt;

    public java_18664_JDBCQueryHandler_A08() {
        try {
            // Load database properties
            Properties prop = new Properties();
            prop.load(getClass().getResourceAsStream("db.properties"));

            // Establish connection to the database
            Class.forName(prop.getProperty("driver"));
            conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // handle the result set
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        jdbcQueryHandler.executeQuery("SELECT * FROM users WHERE username = ?");
    }
}