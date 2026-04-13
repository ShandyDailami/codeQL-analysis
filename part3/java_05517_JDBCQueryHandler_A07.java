import java.sql.*;

public class java_05517_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare Statement
            Statement statement = connection.createStatement();

            // Step 4: Execute Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

            // Step 5: Process Result Set
            while (resultSet.next()) {
                System.out.println(resultSet.getString("mycolumn"));
            }

            // Step 6: Clean Up
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}