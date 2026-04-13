import java.sql.*;

public class java_32210_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // 1. Establish the connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // 2. Prepare the SQL statement
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // 3. Set the parameter value
            preparedStatement.setString(1, "admin");

            // 4. Execute the query and process the result
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("password"));
            }

            // 5. Close the connection
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}