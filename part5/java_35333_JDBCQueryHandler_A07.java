import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_35333_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_name"; // replace with your database URL
        String username = "username"; // replace with your username
        String password = "password"; // replace with your password

        try {
            // 1. Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // 3. Create a statement
            Statement statement = connection.createStatement();

            // 4. Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM table_name"); // replace with your query

            // 5. Process the ResultSet
            while (resultSet.next()) {
                System.out.println("Row 1: " + resultSet.getString("column_name1")); // replace with your column names
                System.out.println("Row 2: " + resultSet.getString("column_name2")); // replace with your column names
                // ... and so on for all columns
            }

            // 6. Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}