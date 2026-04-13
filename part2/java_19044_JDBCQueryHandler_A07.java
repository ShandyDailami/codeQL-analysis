import java.sql.*;

public class java_19044_JDBCQueryHandler_A07 {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Step 2: Prepare a Statement
            String sql = "SELECT * FROM myTable";
            Statement statement = connection.createStatement();

            // Step 3: Execute the SQL Query
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 5: Close the Connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}