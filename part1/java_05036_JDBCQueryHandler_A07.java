import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class java_05036_JDBCQueryHandler_A07 {

    private Connection connection;
    private String user;
    private String password;

    public java_05036_JDBCQueryHandler_A07() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("credentials.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.user = properties.getProperty("user");
        this.password = properties.getProperty("password");
    }

    public void connectToDatabase(String dbUrl, String dbName) {
        try {
            this.connection = DriverManager.getConnection(dbUrl + dbName, this.user, this.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}