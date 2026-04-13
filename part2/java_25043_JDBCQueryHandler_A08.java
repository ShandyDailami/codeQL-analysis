import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_25043_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "your_username";
    private static final String password = "your_password";

    private Connection conn;

    public java_25043_JDBCQueryHandler_A08() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query, boolean isSecuritySensitive) {
        if (isSecuritySensitive) {
            // Security-sensitive operation, so we'll use PreparedStatement instead of just PreparedStatement
            try {
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.execute();
                ResultSet rs = pstmt.getResultSet();
                while (rs.next()) {
                    System.out.println("Result: " + rs.getString("your_column_name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.println("Result: " + rs.getString("your_column_name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}