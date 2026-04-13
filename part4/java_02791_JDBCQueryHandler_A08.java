import java.sql.*;

public class java_02791_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a SQL query
            String query = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 123); // Replace 123 with the actual id

            // Step 3: Execute the SQL query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // Handle the data as needed
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}