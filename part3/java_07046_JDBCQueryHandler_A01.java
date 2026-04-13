import java.sql.*;

public class java_07046_JDBCQueryHandler_A01 {
    // Define the database credentials
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";

    // Define the SQL query
    private static final String SQL_QUERY = "SELECT * FROM your_table";

    public static void main(String[] args) {
        try {
            // Load the driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Prepare the statement
            Statement statement = connection.createStatement();

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            // Process the result set
            while (resultSet.next()) {
                // Extract and print the data
                System.out.println("Data: " + resultSet.getString("your_column_name"));
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}