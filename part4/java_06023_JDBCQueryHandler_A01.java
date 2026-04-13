import java.sql.*;

public class java_06023_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/db_name";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String selectQuery = "SELECT * FROM your_table"; // Replace with your query
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                System.out.println("Row 1: " + resultSet.getString("column1")); // Replace "column1" with your actual column names
                System.out.println("Row 2: " + resultSet.getString("column2"));
                // and so on...
           
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}