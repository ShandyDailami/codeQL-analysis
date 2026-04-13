import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_05790_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    static class Injection implements Runnable {
        @Override
        public void run() {
            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                pstmt = conn.prepareStatement("SELECT * FROM Users WHERE username=?");
                pstmt.setString(1, "admin' --"); // This is a bad example of SQL Injection
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    System.out.println(rs.getString("username"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Injection()).start();
    }
}