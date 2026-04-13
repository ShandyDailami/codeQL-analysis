import java.sql.*;

public class java_06300_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a Connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a Statement
            statement = connection.createStatement();

            // Step 4: Execute a Query
            resultSet = statement.executeQuery("SELECT * FROM myTable");

            // Step 5: Process the ResultSet
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("ID"));
                System.out.println("Name: " + resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}