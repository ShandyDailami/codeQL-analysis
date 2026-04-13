import java.sql.*;

public class java_41359_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "user";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();

            // Start with a secure operation, for example, finding a user by ID
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE ID = " + args[0]);

            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("NAME"));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}