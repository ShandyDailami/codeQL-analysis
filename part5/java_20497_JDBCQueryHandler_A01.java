import java.sql.*;

public class java_20497_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // step 1: establish a connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database!");

            // step 2: create a statement
            Statement stmt = conn.createStatement();

            // step 3: execute a query
            String sql = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(sql);

            // step 4: process the results
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            // step 5: clean up
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Disconnected from database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}