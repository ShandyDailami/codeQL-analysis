import java.sql.*;

public class java_26671_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "username";
    private static final String password = "password";

    private static Connection conn;
    private static Statement stmt;

    public static void main(String[] args) {
        connectToDB();
        executeQuery();
        closeConnection();
    }

    private static void connectToDB() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeQuery() {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM A08_IntegrityFailure");
            while (rs.next()) {
                System.out.println(rs.getString("id") + " - " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}