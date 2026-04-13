import java.sql.*;

public class java_26790_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            //Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            //Step 2: Prepare a Statement
            Statement statement = connection.createStatement();

            //Step 3: Execute a Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");

            //Step 4: Process the Results
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }

            //Step 5: Cleanup
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}