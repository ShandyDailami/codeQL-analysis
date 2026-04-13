import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_00968_JDBCQueryHandler_A03 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public void runQuery(String query) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Step 3: Prepare the statement
            pstmt = conn.prepareStatement(query);

            // Step 4: Execute the query
            pstmt.execute();

            // Step 5: Clean up
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Error in JDBC code");
        }
    }
}