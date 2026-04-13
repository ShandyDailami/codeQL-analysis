import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_14016_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        // Load the MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java驱动程序不存在。");
            e.printStackTrace();
            return;
        }

        // Connect to the MySQL database
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb?useSSL=false", "username", "password");

            // Prepare a statement
            statement = connection.prepareStatement("SELECT * FROM employees");

            // Execute the statement
            resultSet = statement.executeQuery();

            // Print the results
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Salary: " + resultSet.getDouble("salary"));
            }

        } catch (SQLException e) {
            System.out.println("连接数据库时发生错误。");
            e.printStackTrace();

        } finally {
            // Close the resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("关闭ResultSet时发生错误。");
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("关闭Statement时发生错误。");
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("关闭Connection时发生错误。");
                    e.printStackTrace();
                }
            }
        }
    }
}