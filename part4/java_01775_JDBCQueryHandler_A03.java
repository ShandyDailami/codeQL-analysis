import java.sql.*;

public class java_01775_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a Connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a statement
            statement = connection.createStatement();

            // Step 4: Execute the SQL Query
            String sql = "SELECT * FROM my_table";
            resultSet = statement.executeQuery(sql);

            // Step 5: Process the Result Set
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                System.out.println("id = " + id + ", name = " + name);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
            if (resultSet != null) try { resultSet.close(); } catch(SQLException e){ /* can ignore */ }
            if (statement != null) try { statement.close(); } catch(SQLException e){ /* can ignore */ }
            if (connection != null) try { connection.close(); } catch(SQLException e){ /* can ignore */ }
        }
    }
}