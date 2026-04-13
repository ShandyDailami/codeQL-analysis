import java.sql.*;

public class java_28332_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection conn;
    private Statement stmt;

    public java_28332_JDBCQueryHandler_A07() {
        try {
            this.conn = DriverManager.getConnection(URL, USER, PASS);
            this.stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet runQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int runUpdate(String query) {
        int result = 0;
        try {
            result = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        String query = "SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
        ResultSet rs = handler.runQuery(query);

        try {
            if (rs.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}