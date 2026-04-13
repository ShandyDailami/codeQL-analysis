import java.sql.*;

public class java_31562_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/dbname";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the SQL statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");

            // Step 4: Process the result set
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                //...
            }

            // Step 5: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}