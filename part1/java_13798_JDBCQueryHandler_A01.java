import java.sql.*;

public class java_13798_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a SQL query
            Statement statement = connection.createStatement();
            String sql = "UPDATE users SET password = 'new_password' WHERE username = 'admin'";

            // Step 4: Execute the SQL query
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 5: Handle the result
            while (resultSet.next()) {
                String updatedPassword = resultSet.getString("password");
                System.out.println("Updated password is: " + updatedPassword);
            }

            // Step 6: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}