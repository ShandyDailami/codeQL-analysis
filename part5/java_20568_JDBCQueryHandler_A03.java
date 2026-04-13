import java.sql.*;

public class java_20568_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private Connection conn;

    public java_20568_JDBCQueryHandler_A03() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query, Object... parameters) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);

            for (int i = 0; i < parameters.length; i++) {
                pstmt.setObject(i + 1, parameters[i]);
            }

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // handle the result set here
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}