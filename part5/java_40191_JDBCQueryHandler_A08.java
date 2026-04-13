import java.sql.*;

public class java_40191_JDBCQueryHandler_A08 {

    private Connection conn;

    public java_40191_JDBCQueryHandler_A08(String dbUrl, String userName, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbUrl, userName, password);
    }

    public void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(query);
    }

    public static void main(String[] args) {
        try {
            VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/test", "user", "password");

            ResultSet rs = handler.executeQuery("SELECT * FROM Employees");

            while (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt("id"));
                System.out.println("Employee Name: " + rs.getString("name"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}