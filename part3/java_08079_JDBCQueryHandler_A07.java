import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_08079_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // Prepare the SQL statement
            String SQL = "SELECT * FROM Users WHERE username = ? AND password = ?";
            preparedStatement = connection.prepareStatement(SQL);

            // Set the parameters
            preparedStatement.setString(1, "user1");
            preparedStatement.setString(2, "password1");

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Handle the result set
            while (resultSet.next()) {
                System.out.println("User found!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            if (resultSet != null) try { resultSet.close(); } catch(SQLException e) {}
            if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException e) {}
            if (connection != null) try { connection.close(); } catch(SQLException e) {}
        }
    }
}