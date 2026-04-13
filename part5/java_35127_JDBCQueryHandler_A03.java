import java.sql.*;

public class java_35127_JDBCQueryHandler_A03 {

    // Hardcoded username and password for the sake of simplicity
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    // The database URL for simplicity
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the Connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Step 3: Execute a Query
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM my_table");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                System.out.println(rs.getString("my_column"));
            }

            // Step 5: Cleanup
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}