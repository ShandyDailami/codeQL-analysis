import java.sql.*;

public class java_05084_JDBCQueryHandler_A03 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a Query
            String query = "SELECT * FROM Users WHERE UserID = " + args[0];
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                String userId = resultSet.getString("UserID");
                String userName = resultSet.getString("UserName");
                System.out.println("User ID: " + userId);
                System.out.println("User Name: " + userName);
            }

            // Step 5: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}