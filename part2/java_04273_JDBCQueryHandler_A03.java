import java.sql.*;

public class java_04273_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            Statement statement = connection.createStatement();

            // Step 4: Prepare the SQL query
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Step 5: Set the parameter values
            preparedStatement.setString(1, "user1");
            preparedStatement.setString(2, "password1");

            // Step 6: Execute the SQL query
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A user has been inserted into the database.");
            } else {
                System.out.println("No user was inserted.");
            }

            // Step 7: Fetch the user back
            String sql2 = "SELECT * FROM users WHERE username=?";
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
            } else {
                System.out.println("No user was found with the provided username.");
            }

            // Step 8: Close the connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}