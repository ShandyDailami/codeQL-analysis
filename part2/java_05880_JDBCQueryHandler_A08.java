import java.sql.*;

public class java_05880_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a Query
            String query = "SELECT * FROM Users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 123); // replace with the actual id

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            // Step 4: Close the Connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}