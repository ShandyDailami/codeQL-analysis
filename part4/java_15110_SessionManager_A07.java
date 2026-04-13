import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;
import java.sql.TransactionIsolationLevel;

public class java_15110_SessionManager_A07 {

    public static void main(String[] args) {

        // Load JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Create a connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydatabase?useSSL=false", "username", "password")) {

            // Create a session
            Session session = connection.createSession(false, Session.AUTOCOMMIT);

            // Begin a transaction
            session.beginTransaction();

            // Perform a select operation
            String sql = "SELECT * FROM my_table WHERE id = :id";
            java.sql.PreparedStatement pstmt = session.prepareStatement(sql);
            pstmt.setInt(1, 123);

            // Execute the query
            java.sql.ResultSet rs = pstmt.executeQuery();

            // Process the result
            while (rs.next()) {
                // Do something with the result
                System.out.println(rs.getString("column_name"));
            }

            // Commit the transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}