import java.sql.*;

public class java_40569_JDBCQueryHandler_A03 {
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;

    public java_40569_JDBCQueryHandler_A03(String dbUrl, String dbUsername, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
    }

    public String createQuery(String query) {
        String secureQuery = "";
        try {
            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnsNumber = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = resultSet.getString(i);
                    // Use a method to securely sanitize the column value
                    columnValue = sanitizeColumnValue(columnValue);
                    secureQuery += columnValue + ",";
                }
            }
            secureQuery = secureQuery.substring(0, secureQuery.length() - 1); // Remove the last comma
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return secureQuery;
    }

    private String sanitizeColumnValue(String columnValue) {
        // Here you can implement the sanitization logic
        return columnValue; // Just return the sanitized value as we don't have actual sanitization logic here
    }
}