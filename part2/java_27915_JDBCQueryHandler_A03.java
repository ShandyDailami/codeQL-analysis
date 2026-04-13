import java.sql.*;

public class java_27915_JDBCQueryHandler_A03 {
    private Connection connection;
    private PreparedStatement statement;

    public java_27915_JDBCQueryHandler_A03(String url, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // assuming you're using MySQL
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query, Object... parameters) {
        try {
            this.statement = this.connection.prepareStatement(query);
            for (int i = 0; i < parameters.length; i++) {
                this.statement.setObject(i + 1, parameters[i]); // assuming the parameters are 1-indexed
            }
            this.statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query, boolean returnResultSet, Object... parameters) {
        try {
            this.statement = this.connection.prepareStatement(query);
            for (int i = 0; i < parameters.length; i++) {
                this.statement.setObject(i + 1, parameters[i]); // assuming the parameters are 1-indexed
            }
            if (returnResultSet) {
                return this.statement.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() {
        try {
            if (this.statement != null) {
                this.statement.close();
            }
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}