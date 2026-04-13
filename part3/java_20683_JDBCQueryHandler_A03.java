import java.sql.*;

public class java_20683_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");

            // Create a statement
            statement = connection.createStatement();

            // Execute a SQL query
            String sql = "SELECT * FROM my_table";
            resultSet = statement.executeQuery(sql);

            // Process the results
            while (resultSet.next()) {
                System.out.println(resultSet.getString("my_column"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the resources
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