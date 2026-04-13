import java.sql.*;

public class java_14006_JDBCQueryHandler_A03 {

    // Assume the database connection properties are defined here
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish a connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the statement
            statement = connection.prepareStatement("INSERT INTO myTable (name, age) VALUES (?, ?)");

            // Step 3: Execute the statement
            statement.setString(1, "John Doe");
            statement.setInt(2, 25);
            statement.executeUpdate();

            // Step 4: Handle the result
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Age: " + resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}