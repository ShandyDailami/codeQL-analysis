import java.sql.*;

public class java_39044_JDBCQueryHandler_A01 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String query = "username' or '1'='1"; // SQL Injection attack
        queryHandler(query);
    }

    public static void queryHandler(String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // load MySQL Driver
            Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query); // execute the SQL query

            while (rs.next()) {
                System.out.println("Username: " + rs.getString("username"));
            }

            con.close(); // close connection

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}