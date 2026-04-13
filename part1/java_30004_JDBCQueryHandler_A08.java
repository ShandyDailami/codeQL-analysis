import java.sql.*;

public class java_30004_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/dbname";
    private static final String username = "username";
    private static final String password = "password";

    private Connection conn = null;
    private Statement stmt = null;

    public java_30004_JDBCQueryHandler_A08() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int executeUpdate(String query) {
        int rowsUpdated = 0;
        try {
            rowsUpdated = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        ResultSet rs = handler.executeQuery("SELECT * FROM Users WHERE Email = '" + args[0] + "' AND Password = '" + args[1] + "'");
        try {
            if (rs.next()) {
                System.out.println("User exists");
            } else {
                System.out.println("User does not exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}