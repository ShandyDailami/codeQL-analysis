import java.sql.*;

public class java_28852_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_28852_JDBCQueryHandler_A03(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public void executeStoredProcedure(String procedureName) throws SQLException {
        CallableStatement statement = connection.prepareCall(procedureName);

        // Bind parameters
        statement.setInt(1, 1);
        statement.setString(2, "test");

        // Execute the procedure
        statement.execute();

        // Close the callable statement and the connection
        statement.close();
        connection.close();
    }
}