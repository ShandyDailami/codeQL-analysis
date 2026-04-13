import java.sql.*;

public class java_40407_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Register MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare statement
            String query = "SELECT * FROM my_table";
            Statement statement = connection.createStatement();

            // Step 4: Execute query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Process result
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                String column2 = resultSet.getString("column2");

                // Do something with the data
            }

            // Step 6: Close connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}