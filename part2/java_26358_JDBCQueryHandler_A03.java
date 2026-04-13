import java.sql.*;

public class java_26358_JDBCQueryHandler_A03 {
    private static String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static String username = "root";
    private static String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM my_table"; // replace with your query
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                // process the data
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}