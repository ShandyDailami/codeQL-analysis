import java.sql.*;

public class java_31978_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 3: Set the parameter and execute the query
            preparedStatement.setInt(1, 123);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Step 4: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}