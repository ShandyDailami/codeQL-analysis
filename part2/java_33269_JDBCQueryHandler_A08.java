import java.sql.*;

public class java_33269_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Connect to the database
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare the statement
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE name = 'test'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 3: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 4: Close the ResultSet and the Statement
            rs.close();
            stmt.close();

            // Step 5: Close the Connection
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}