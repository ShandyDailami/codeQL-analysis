import java.sql.*;

public class java_24813_JDBCQueryHandler_A03 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        try {
            // Step 1: Register JDBC driver
            Class.forName(DB_DRIVER);

            // Step 2: Open a connection
            con = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Execute a query
            stmt = con.createStatement();
            String sql = "SELECT * FROM EMPLOYEE WHERE AGE > '30'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Extract data from result set
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String city = rs.getString("CITY");
                System.out.println(id + " " + name + " " + city);
            }
            // Step 5: Clean-up environment
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();