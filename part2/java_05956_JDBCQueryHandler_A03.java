import java.sql.*;

public class java_05956_JDBCQueryHandler_A03 {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    private String url;
    private String username;
    private String password;

    public java_05956_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        try {
            this.conn = DriverManager.getConnection(url, username, password);
            this.stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            this.rs = stmt.executeQuery(query);
            processResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void processResultSet() {
        int columnsNum = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNum; i++) {
                String columnValue = rs.getString(i);
                // Process the column value
                System.out.println("Column Value: " + columnValue);
            }
        }
    }

    public void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}