import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_21100_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myusername";
    private static final String PASS = "mypassword";

    public static List<String> getUsers() {
        List<String> users = new ArrayList<>();

        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Prepare a statement
            String sql = "SELECT username FROM users";
            Statement stmt = conn.createStatement();

            // Execute the statement and get the result set
            ResultSet rs = stmt.executeQuery(sql);

            // Process the result set
            while (rs.next()) {
                users.add(rs.getString("username"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static void main(String[] args) {
        List<String> users = getUsers();
        users.forEach(System.out::println);
    }
}