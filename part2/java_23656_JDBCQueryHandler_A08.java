import java.sql.*;

public class java_23656_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_name";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the statement
            String query = "SELECT * FROM table_name";
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the result
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                double column3 = resultSet.getDouble("column3");

                // Print the result
                System.out.println("Column 1: " + column1);
                System.out.println("Column 2: " + column2);
                System.out.println("Column 3: " + column3);
            }

            // Step 5: Clean up
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}