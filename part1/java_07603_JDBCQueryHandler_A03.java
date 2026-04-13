import java.sql.*;

public class java_07603_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Query 1
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM table1");

            while (resultSet1.next()) {
                String column1 = resultSet1.getString("column1");
                // perform some operations
            }

            // Query 2
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM table2");

            while (resultSet2.next()) {
                String column2 = resultSet2.getString("column2");
                // perform some operations
           
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}