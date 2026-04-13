import java.sql.*;

public class java_07587_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String sql = "SELECT * FROM table";
            Statement statement = connection.createStatement();

            // Step 3: Execute the statement and process the result
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 4: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database");
            e.printStackTrace();
        }
    }
}