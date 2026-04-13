import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_33293_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_33293_JDBCQueryHandler_A08() {
        initializeConnection();
    }

    private void initializeConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., by logging the error or taking appropriate action
        }
    }

    public List<String> getColumnNames(String tableName) {
        List<String> columnNames = new ArrayList<>();
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet columns = metaData.getColumns(null, null, tableName, null);
            while (columns.next()) {
                columnNames.add(columns.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnNames;
    }

    public void insertIntoTable(String tableName, List<String> columnNames, List<String> values) {
        StringBuilder columns = new StringBuilder();
        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < columnNames.size(); i++) {
            columns.append(columnNames.get(i));
            if (i < columnNames.size() - 1) {
                columns.append(", ");
                placeholders.append(", ");
            }
        }

        String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + placeholders + ")";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < columnNames.size(); i++) {
                statement.setString(i + 1, values.get(i));
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTable(String tableName, String columnName, String newValue, String condition) {
        String query = "UPDATE " + tableName + " SET " + columnName + " = ? WHERE " + condition;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newValue);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromTable(String tableName, String condition) {
        String query = "DELETE FROM " + tableName + " WHERE " + condition;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}