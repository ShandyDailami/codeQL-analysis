import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_26198_JDBCQueryHandler_A01 {

    // The URL, username, and password for your database.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_db_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private Connection conn;
    private Statement stmt;

    public java_26198_JDBCQueryHandler_A01() {
        try {
            // Step 1: Register MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            this.conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Prepare a statement
            this.stmt = conn.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            // Step 4: Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Step 5: Process the results
            while (rs.next()) {
                // This is just a placeholder. Real-world application may process the results differently.
                System.out.println(rs.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM your_table_name");
    }
}