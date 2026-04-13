import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_26836_JDBCQueryHandler_A08 {
    // Define a method to connect to the database.
    private Connection getConnection(String url, String user, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error in connecting to database");
            e.printStackTrace();
        }
        return conn;
    }

    // Define a method to disconnect from the database.
    private void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error in closing connection");
            e.printStackTrace();
        }
    }

    // Define a method to perform a query.
    public ResultSet executeQuery(String url, String user, String password, String query) {
        Connection conn = getConnection(url, user, password);
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error in executing query");
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
        return rs;
    }

    // Define a method to perform an insert, update, delete operation.
    public int executeUpdate(String url, String user, String password, String query) {
        Connection conn = getConnection(url, user, password);
        Statement stmt = null;
        int rowsInserted = 0;
        try {
            stmt = conn.createStatement();
            rowsInserted = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error in executing update");
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
        return rowsInserted;
    }
}