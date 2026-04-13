import java.sql.*;

public class java_23141_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        try {
            // establish a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password");

            // create a statement
            Statement stmt = conn.createStatement();

            // execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username='admin' AND password='password'");

            // process the result set
            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("username"));
            }

            // close the connection
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }
}