import java.sql.*;

public class java_01374_JDBCQueryHandler_A01 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {

        try {
            // Step 1: Establish a Connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a Statement
            Statement stmt = con.createStatement();

            // Step 3: Execute a Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE name='John'");

            // Step 4: Process the Result
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
            }

            // Step 5: Close the Connection
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}