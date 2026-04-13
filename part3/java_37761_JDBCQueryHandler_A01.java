import java.sql.*;

public class java_37761_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM mytable";
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Handle the ResultSet
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                // ... and so on
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}