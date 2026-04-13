import java.sql.*;

public class java_04642_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM my_table";
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    String column1 = resultSet.getString("column1");
                    int column2 = resultSet.getInt("column2");
                    float column3 = resultSet.getFloat("column3");
                    // Handle the data as per your requirements
                }

                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found!");
        }
        return connection;
    }
}