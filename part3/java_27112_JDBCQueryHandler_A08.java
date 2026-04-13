import java.sql.*;

public class java_27112_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM mytable";
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}