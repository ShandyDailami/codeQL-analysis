import java.sql.*;

public class java_35184_JDBCQueryHandler_A03 {
    // Connection object
    private Connection conn = null;

    // Constructor to initialize database connection
    public java_35184_JDBCQueryHandler_A03() {
        try {
            // Loading Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database URL
            String url = "jdbc:mysql://localhost:3306/mydb";

            // Database username and password
            String username = "root";
            String password = "password";

            // Establishing Connection
            conn = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to execute read queries
    public ResultSet executeReadQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
       
        return null;
        }
    }

    // Method to execute write queries
    public int executeWriteQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Method to close connection
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}