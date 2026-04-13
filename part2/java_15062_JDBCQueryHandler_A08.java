import java.sql.*;
import java.util.Properties;

public class java_15062_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_15062_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", username);
            props.setProperty("password", password);
            this.conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error executing update: " + e.getMessage());
            return -1;
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "password");
        ResultSet rs = handler.executeQuery("SELECT * FROM users WHERE role = 'admin'");
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
        handler.closeConnection();
    }
}