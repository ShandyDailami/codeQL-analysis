import java.sql.*;

public class java_07511_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb"; // use your DB URL
        String username = "root"; // use your username
        String password = "password"; // use your password

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM my_table"; // replace with your query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String column1 = resultSet.getString("column1"); // replace with your column names
                String column2 = resultSet.getString("column2");
                // ...

                System.out.println("Column1: " + column1);
                System.out.println("Column2: " + column2);
                // ...
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}