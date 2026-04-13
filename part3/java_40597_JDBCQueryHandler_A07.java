import java.sql.*;

public class java_40597_JDBCQueryHandler_A07 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Step 2: Create a Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'test' AND password = 'test'");

            // Step 4: Process the Result
            while (resultSet.next()) {
                System.out.println("User found!");
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