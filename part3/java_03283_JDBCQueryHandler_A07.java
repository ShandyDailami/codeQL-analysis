import java.sql.*;

public class java_03283_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a statement
            statement = connection.createStatement();

            // Step 4: Execute a SQL Query
            String sql = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            resultSet = statement.executeQuery(sql);

            // Step 5: Handle the result
            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close connection, statement, and result set
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { /* ignore */ }
            if (statement != null) try { statement.close(); } catch (SQLException e) { /* ignore */ }
            if (connection != null) try { connection.close(); } catch (SQLException e) { /* ignore */ }
        }
    }
}