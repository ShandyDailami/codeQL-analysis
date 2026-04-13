import java.sql.*;

public class java_10787_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();

            // Sample query
            String query = "SELECT * FROM table_name WHERE column_name = 'value'";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Process the result set here
                System.out.println("Column1: " + rs.getString("column1"));
                System.out.println("Column2: " + rs.getString("column2"));
                // And so on...
           
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error executing query or connection: " + e.getMessage());
        }
    }
}