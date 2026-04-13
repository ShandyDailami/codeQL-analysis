import java.sql.*;

public class java_23711_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            String query = "SELECT * FROM myTable WHERE column = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, "testValue"); // This is a security-sensitive operation.

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println(result.getString("column"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}