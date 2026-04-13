import java.sql.*;

public class java_04853_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_04853_JDBCQueryHandler_A03(String url, String user, String password) {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query, Object[] parameters, ResultHandler handler) {
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            for (int i = 0; i < parameters.length; i++) {
                stmt.setObject(i + 1, parameters[i]);
            }
            stmt.setResultSetExtraction(handler);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Replace with your own parameters
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "myuser";
        String password = "mypassword";
        String query = "SELECT * FROM users WHERE id = ?";
        Object[] parameters = {100};

        // Define your own ResultHandler implementation
        ResultHandler handler = new MyResultHandler();

        JDBCQueryHandler handlerInstance = new JDBCQueryHandler(url, user, password);
        handlerInstance.executeQuery(query, parameters, handler);
    }
}

class MyResultHandler implements ResultHandler {
    @Override
    public void setResultSet(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
    }
}