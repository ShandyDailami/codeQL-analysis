import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_37163_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_37163_JDBCQueryHandler_A07(String dbURL, String user, String password) {
        try {
            // Step 1: Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the database
            this.connection = DriverManager.getConnection(dbURL, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            // Step 3: Create a prepared statement
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);

            // Step 4: Execute the query and get the result set
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            // Step 3: Create a prepared statement
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);

            // Step 4: Execute the query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            // Step 5: Close the connection
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "root", "password");

        // Example of a query
        ResultSet resultSet = handler.executeQuery("SELECT * FROM Users WHERE Email = ?");

        // Fetching the result
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Email"));
        }

        handler.closeConnection();
    }
}