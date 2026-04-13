import java.sql.*;

public class java_23588_JDBCQueryHandler_A07 {

    // The database credentials
    private static final String DB_USER = "db_user";
    private static final String DB_PASSWORD = "db_password";

    // The database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_name";

    // The SQL query
    private static final String SQL_QUERY = "SELECT * FROM table_name WHERE condition";

    public static void main(String[] args) {
        // Create a connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the SQL query
            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            // Process the result set
            while (resultSet.next()) {
                // Assuming the table has two columns: id and name
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}