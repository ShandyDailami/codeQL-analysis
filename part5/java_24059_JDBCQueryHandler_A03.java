import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class java_24059_JDBCQueryHandler_A03 {
    private Connection connection;

    // Load properties file
    private Properties prop;

    public java_24059_JDBCQueryHandler_A03() {
        prop = new Properties();

        try {
            prop.load(new FileInputStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(prop.getProperty("driver"));
                connection = DriverManager.getConnection(
                        prop.getProperty("url"),
                        prop.getProperty("username"),
                        prop.getProperty("password")
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}