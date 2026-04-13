import com.mysql.cj.jdbc.Driver;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_28448_JDBCQueryHandler_A08 {

    private BasicDataSource dataSource;

    public java_28448_JDBCQueryHandler_A08() {
        Driver driver = new Driver();
        dataSource = new BasicDataSource();

        dataSource.setDriverClass(Driver.class.getName());
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dbname");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public void performQuery(String query) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // TODO: Handle the result set data
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources in reverse order of declaration
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}