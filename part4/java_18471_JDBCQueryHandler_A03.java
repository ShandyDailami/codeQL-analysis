import java.sql.*;

public class java_18471_JDBCQueryHandler_A03 {
    //Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            //Step 1: Establish a connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Step 2: Prepare a statement
            String query = "SELECT * FROM myTable";
            Statement stmt = conn.createStatement();

            //Step 3: Execute the query
            ResultSet rs = stmt.executeQuery(query);

            //Step 4: Process the results
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            //Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}