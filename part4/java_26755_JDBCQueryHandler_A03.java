import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_26755_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM my_table";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                double column3 = resultSet.getDouble("column3");

                System.out.println("Column1: " + column1);
                System.out.println("Column2: " + column2);
                System.out.println("Column3: " + column3);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}