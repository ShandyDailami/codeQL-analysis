import java.sql.*;

public class java_28820_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            //Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Step 2: Open a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            //Step 3: Execute a query
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM employees WHERE id = " + args[0];
            ResultSet resultSet = statement.executeQuery(sql);

            //Step 4: Process the result
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            //Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}