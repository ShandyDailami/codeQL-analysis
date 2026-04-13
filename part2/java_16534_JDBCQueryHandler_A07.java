import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class java_16534_JDBCQueryHandler_A07 {

    // Constructor to initialize the database properties
    public java_16534_JDBCQueryHandler_A07() {
        Properties props = new Properties();
        props.setProperty("user", "dbUser");
        props.setProperty("password", "dbPassword");
        props.setProperty("useSSL", "false");
        props.setProperty("autoReconnect", "true");
        props.setProperty("characterEncoding", "utf8");
        props.setProperty("rewriteBatchedStatements", "true");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbName", props);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Connection conn = null;

    // Method to execute SQL queries
    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler();
        ResultSet rs = jdbcHandler.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        jdbcHandler.closeConnection();
    }
}