import java.sql.*;

public class java_03055_JDBCQueryHandler_A03 {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public java_03055_JDBCQueryHandler_A03() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("User Name: " + resultSet.getString("name"));
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}