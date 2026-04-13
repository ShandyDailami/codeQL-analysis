import java.sql.*;

public class java_23541_JDBCQueryHandler_A03 {

    private String url;
    private String username;
    private String password;

    public java_23541_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void performQuery(String query) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 3: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the results
            while (resultSet.next()) {
                // Here you can write your code to process the results.
                // For example, you might print the result to the console.
                System.out.println(resultSet.getString("columnName"));
            }

            // Step 5: Close the connection
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            // Handle any exceptions that might have occurred.
            e.printStackTrace();
        }
    }
}