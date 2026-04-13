import java.sql.*;

public class java_25786_JDBCQueryHandler_A03 {

    // JDBC driver name and database URL
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Load the MySQL driver
            Class.forName(driver);

            // Open a connection
            System.out.println("Connecting to database...");
            Connection con = DriverManager.getConnection(url, username, password);

            // Perform SQL query
            System.out.println("Connection successful");
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM employees";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract and print data from result set
            while (rs.next()) {
                System.out.println("ID = " + rs.getString("id"));
                System.out.println("Name = " + rs.getString("name"));
                System.out.println("Salary = " + rs.getString("salary"));
            }

            // Close the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error in connection");
            e.printStackTrace();
        }
    }
}