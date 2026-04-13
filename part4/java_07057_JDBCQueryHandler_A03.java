import java.sql.*;

public class java_07057_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        try {
            // Step 1: Establish a connection to the database.
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a SQL query.
            String sql = "SELECT * FROM mytable";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Step 3: Execute the SQL query.
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the result set.
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                // ... process the data ...
            }

            // Step 5: Close the resources.
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}