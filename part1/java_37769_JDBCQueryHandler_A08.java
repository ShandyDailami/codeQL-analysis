import java.sql.*;

public class java_37769_JDBCQueryHandler_A08 {

    public static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a Connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement object
            stmt = conn.createStatement();

            // Step 3: Execute a SQL query
            String sql = "SELECT * FROM Users WHERE Age = " + 20;
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                String address = rs.getString("Address");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Address: " + address);
            }

            // Close the ResultSet and Statement
            rs.close();
            stmt.close();

            // Close the Connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}