import java.sql.*;

public class java_15205_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement object
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            // Step 4: Process the result set
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " + resultSet.getString("salary"));
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