import java.sql.*;
import java.util.Properties;

public class java_42027_JDBCQueryHandler_A01 {
    // create a function to connect to the database
    private Connection connectToDB(String dbURL, String user, String password) {
        Connection conn = null;
        try {
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            props.setProperty("characterEncoding", "utf-8");
            conn = DriverManager.getConnection(dbURL, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // create a function to perform a query
    public void performQuery(String query, String dbURL, String user, String password) {
        Connection conn = connectToDB(dbURL, user, password);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // create a function to perform a security sensitive operation
    public void performSecuritySensitiveOperation(String dbURL, String user, String password) {
        // a simple example of a query to select all users in a database
        String query = "SELECT * FROM users";
        performQuery(query, dbURL, user, password);
    }
}