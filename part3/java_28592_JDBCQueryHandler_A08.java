import java.sql.*;

public class java_28592_JDBCQueryHandler_A08 {

    // Hardcoded username and password for demonstration purpose
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/database_name";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM table_name");

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                // Accessing individual columns
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                // ...

                // Use the columns in your security-sensitive operations here
                // For example, you can log the data
                System.out.println("column1: " + column1);
                System.out.println("column2: " + column2);
                // ...
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}