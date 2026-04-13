import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_29070_JDBCQueryHandler_A03 {

    // The DriverManager will be used to connect to the database.
    private Connection conn;

    // Statement and ResultSet will be used to execute SQL statements.
    private Statement stmt;

    // Constructor
    public java_29070_JDBCQueryHandler_A03(String url, String username, String password) {
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            conn = DriverManager.getConnection(url, username, password);

            // Create a statement
            stmt = conn.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Method to execute SQL queries
    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID = " + rs.getString("id"));
                System.out.println("Name = " + rs.getString("name"));
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            if (stmt != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/dbname", "username", "password");
        handler.executeQuery("SELECT * FROM table_name");
        handler.closeConnection();
    }
}