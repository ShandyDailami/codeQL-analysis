import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.SimpleStatement;
import com.mysql.cj.jdbc.SimpleDataSource;

public class java_39218_JDBCQueryHandler_A08 {
    private SimpleDataSource dataSource;

    public java_39218_JDBCQueryHandler_A08(String url, String username, String password) {
        dataSource = new SimpleDataSource();
        dataSource.setURL(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    public List<String> executeQuery(String sql) {
        List<String> results = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                results.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public void executeUpdate(String sql) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}