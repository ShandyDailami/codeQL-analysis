import java.sql.*;

public class java_23255_JDBCQueryHandler_A01 {

    private Connection conn;
    private Statement stmt;

    public java_23255_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
        stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler(url, username, password);
            ResultSet rs = jdbcQueryHandler.executeQuery("SELECT * FROM employees");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Salary: " + rs.getDouble("salary"));
            }

            jdbcQueryHandler.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}