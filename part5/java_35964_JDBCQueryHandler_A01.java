import java.sql.*;

public class java_35964_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM your_table");

            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                String column2 = resultSet.getString("column2");
                // do something with the data...
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}