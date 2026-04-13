import java.sql.*;

public class java_37156_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:your_db_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM your_table"; // replace with your SQL query
            Statement statement = connection.createStatement();

            // Step 3: Execute the query and process the result
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Assume the table has columns: id, name, and age
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while connecting to the database or executing the query: " + e.getMessage());
        }
    }
}