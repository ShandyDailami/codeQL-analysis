import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_18871_JDBCQueryHandler_A01 {

    public static void main(String[] args) {

        // Step 1: Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java驱动不存在！");
        }

        // Step 2: Establish a connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
        } catch (SQLException e) {
            System.out.println("无法连接到数据库！");
            e.printStackTrace();
            return;
        }

        // Step 3: Create a statement
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("无法创建Statement！");
            e.printStackTrace();
            return;
        }

        // Step 4: Execute the query
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM users";
            resultSet = statement.executeQuery(sql);

            // Step 5: Process the results
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            System.out.println("无法获取数据！");
            e.printStackTrace();
            return;
        } finally {
            // Step 6: Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("无法关闭数据库连接！");
                e.printStackTrace();
            }
        }
    }
}