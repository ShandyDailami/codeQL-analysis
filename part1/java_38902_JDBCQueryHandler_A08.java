import java.sql.*;

public class java_38902_JDBCQueryHandler_A08 {
    private Connection conn;
    private Statement stmt;

    public java_38902_JDBCQueryHandler_A08(String dbURL, String user, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, user, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error in connecting to database");
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // Process the result set here
            }
        } catch (SQLException e) {
            System.out.println("Error in executing query");
            e.printStackTrace();
        }
    }

    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error in executing update query");
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Error in closing the connection");
            e.printStackTrace();
        }
    }
}