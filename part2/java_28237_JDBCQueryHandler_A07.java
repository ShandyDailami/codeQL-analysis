import java.sql.*;

public class java_28237_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb"; // replace with your database url
        String username = "root"; // replace with your username
        String password = "password"; // replace with your password

        try {
            // Step 1: Establish a Connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a Statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute a Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM my_table"); // replace with your query

            // Step 4: Handle the ResultSet
            while (rs.next()) {
                // replace 'column_name' with your column name
                String columnName = rs.getString("column_name");
                System.out.println("Column Name: " + columnName);
            }

            // Step 5: Close the Connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}