import java.sql.*;
import java.util.Properties;

public class java_13885_JDBCQueryHandler_A07 {

    // private fields
    private Connection conn;
    private Statement stmt;

    // constructor
    public java_13885_JDBCQueryHandler_A07() {
        try {
            Properties props = new Properties();
            props.setProperty("user", "username");
            props.setProperty("password", "password");
            props.setProperty("ssl","false");
            props.setProperty("sslfactory","javax.net.ssl.SSLContextFactory");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", props);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // method to execute a SQL query
    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // method to execute a SQL update/delete
    public int executeUpdate(String query) {
        int result = 0;
        try {
            result = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method to close connections and statements
    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // main method
    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();

        // execute a query
        ResultSet rs = jdbcQueryHandler.executeQuery("SELECT * FROM Users");

        // process the result set
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // close the connection
        jdbcQueryHandler.closeConnection();
    }
}