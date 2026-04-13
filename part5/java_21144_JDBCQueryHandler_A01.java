import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_21144_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "CREATE USER 'newuser'@'%' IDENTIFIED BY 'newpassword'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            sql = "GRANT USAGE ON *.* TO 'newuser'@'%'";
            statement.executeUpdate(sql);

            sql = "GRANT ALL PRIVILEGES ON testdb.* TO 'newuser'@'%'";
            statement.executeUpdate(sql);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}