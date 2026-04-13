import java.sql.*;

public class java_24725_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Register Necessary Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a Statement
            Statement statement = connection.createStatement();

            // Step 4: Execute a Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

            // Step 5: Handle the ResultSet
            while (resultSet.next()) {
                System.out.println("Found user!");
            }

            // Step 6: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}