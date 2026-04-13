import java.sql.*;

public class java_18163_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "myUser";
    private static final String password = "myPassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM myTable");

            // Step 4: Process the result
            while (resultSet.next()) {
                System.out.println(resultSet.getString("myColumn"));
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