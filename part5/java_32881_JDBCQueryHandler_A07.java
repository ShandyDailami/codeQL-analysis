import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_32881_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;

    private void connectToDB(String url, String user, String password) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // Here you can handle the results of your query.
                System.out.println("Result: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connectToDB("jdbc:mysql://localhost:3306/db", "username", "password");
        handler.executeQuery("SELECT name FROM users WHERE id = '123'");
        handler.closeConnection();
    }
}