import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_34061_JDBCQueryHandler_A08 {
    // a. Use standard libraries only
    // b. Be creative and realistic
    private String dbUrl = "jdbc:mysql://localhost:3306/testdb";
    private String username = "root";
    private String password = "password";

    // c. Do not use external frameworks
    // d. Make sure the program is syntactically correct
    public void runQuery() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // a. Connect to the database
            conn = DriverManager.getConnection(dbUrl, username, password);

            // b. Use the connection to create a statement
            stmt = conn.createStatement();

            // c. Execute a query
            rs = stmt.executeQuery("SELECT * FROM Employees");

            // d. Print the result set
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Salary: " + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // e. Close the resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}