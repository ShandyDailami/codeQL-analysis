import java.sql.*;

public class java_27656_JDBCQueryHandler_A08 {

    private Connection conn;

    public java_27656_JDBCQueryHandler_A08() {
        // Create a connection to the database
        try {
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "username",
                    "password"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        // Use a statement to execute the query
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        // Use a statement to execute the update
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        // Close the connection
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}