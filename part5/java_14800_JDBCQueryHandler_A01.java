import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_14800_JDBCQueryHandler_A01 {

    private Connection conn;
    private Statement stmt;

    public java_14800_JDBCQueryHandler_A01(String dbUrl, String username, String password) {
        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
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
        // Create a new instance of the JDBCQueryHandler with your database credentials
        VanillaJDBCQueryHandler jdbcQueryHandler = new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/db", "username", "password");

        // Execute a query and print the result
        ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM users");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }

        // Close the connection
        jdbcQueryHandler.closeConnection();
    }
}