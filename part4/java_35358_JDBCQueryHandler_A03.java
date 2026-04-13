import java.sql.*;

public class java_35358_JDBCQueryHandler_A03 {

    // This is your database credentials
    private static final String USER = "your_username";
    private static final String PASS = "your_password";
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to the database");

            // Step 2: Create a statement
            Statement stmt = con.createStatement();

            // Step 3: Execute a SQL Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 5: Close the ResultSet and the connection
            rs.close();
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}