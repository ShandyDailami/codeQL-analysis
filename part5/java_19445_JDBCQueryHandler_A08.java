import java.sql.*;
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

public class java_19445_JDBCQueryHandler_A08 {
    private DataSource dataSource;

    // Setup DataSource with connection details
    public java_19445_JDBCQueryHandler_A08() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/dbname?useSSL=false");
        mysqlDataSource.setUser("user");
        mysqlDataSource.setPassword("password");
        this.dataSource = mysqlDataSource;
    }

    public void executeQuery(String query) {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM table_name");
    }
}