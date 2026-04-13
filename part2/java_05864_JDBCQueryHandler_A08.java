import java.sql.*;

public class java_05864_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/databaseName";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            statement = connection.createStatement();

            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tableName WHERE condition");

            // Process the result set
            while (resultSet.next()) {
                // Get the value of each column
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                double column3 = resultSet.getDouble("column3");

                // Do something with the data
                System.out.println(column1 + ", " + column2 + ", " + column3);
           
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            if (statement != null) {
                try { statement.close(); } catch (SQLException e) { /* unable to do anything */ }
            }
            if (connection != null) {
                try { connection.close(); } catch (SQLException e) { /* unable to do anything */ }
            }
        }
    }
}