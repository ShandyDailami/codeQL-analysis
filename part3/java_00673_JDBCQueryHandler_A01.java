import java.sql.*;

public class java_00673_JDBCQueryHandler_A01 {
    private Connection conn;
    private Statement stmt;

    public java_00673_JDBCQueryHandler_A01(String dbURL, String user, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, user, password);
            stmt = conn.createStatement();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void performQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void performUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "myuser", "mypassword");
    }
}