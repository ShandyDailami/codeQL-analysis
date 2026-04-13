import java.sql.*;

public class java_39810_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM my_table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                float column3 = resultSet.getFloat("column3");
                //... handle the rest of the columns here

                System.out.println("Column 1: " + column1);
                System.out.println("Column 2: " + column2);
                System.out.println("Column 3: " + column3);
                //... handle other columns here
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e);
        }
    }
}