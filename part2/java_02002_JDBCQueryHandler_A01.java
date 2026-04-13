import java.sql.*;

public class java_02002_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Open a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM your_table_name";
            Statement statement = connection.createStatement();

            // Step 3: Execute the query and process the result set
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Process each result set row
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                // ...
            }

            // Step 4: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}