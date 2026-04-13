import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_13805_JDBCQueryHandler_A01 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName(DB_DRIVER);

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Execute a query
            String sql = "SELECT id, name, email FROM users";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            // Step 4: Extract data from result set
            List<User> userList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                User user = new User(id, name, email);
                userList.add(user);
            }

            // Step 5: Print out user data
            for (User user : userList) {
                System.out.println(user.toString());
            }

            // Close connections
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se3) {
                se3.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

class User {
    private int id;
    private String name;
    private String email;

    public java_13805_JDBCQueryHandler_A01(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String toString() {
        return "User: ID = " + id + ", Name = " + name + ", Email = " + email;
    }
}