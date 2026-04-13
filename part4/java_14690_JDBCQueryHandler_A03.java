import java.sql.*;

public class java_14690_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM mytable WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 123); // replace 123 with the id you want to query

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println(result.getString("columnName")); // replace "columnName" with the name of the column you want to print
           
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}