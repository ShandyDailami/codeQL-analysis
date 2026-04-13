import java.sql.*;

public class java_33815_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1.  Establish a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2.  Prepare the SQL query
            String query = "SELECT * FROM Users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // 3.  Bind the parameter and execute the query
            preparedStatement.setInt(1, 123); // You should replace this with the actual user id
            resultSet = preparedStatement.executeQuery();

            // 4.  Handle the result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5.  Close the connection
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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