import java.sql.*;

public class java_27047_JDBCQueryHandler_A07 {
    // Define the database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myusername";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        // Create a connection to the database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
       
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Create a statement from the connection
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Execute a query
        String query = "SELECT * FROM my_table";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Handle the result set
        while (resultSet.next()) {
            String column1 = resultSet.getString("column1");
            int column2 = resultSet.getInt("column2");
            //... handle the data as needed
        }
    }
}