import java.sql.*;

public class java_14802_JDBCQueryHandler_A03 {

    public Connection getConnection(String url, String user, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public PreparedStatement getPreparedStatement(Connection connection, String query) {
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    public ResultSet executeQuery(PreparedStatement pstmt) {
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closePreparedStatement(PreparedStatement pstmt) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "password";
        String query = "SELECT * FROM users WHERE email=?";

        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler();
        Connection connection = jdbcHandler.getConnection(url, user, password);
        PreparedStatement pstmt = jdbcHandler.getPreparedStatement(connection, query);
        pstmt.setString(1, "test@test.com");

        ResultSet rs = jdbcHandler.executeQuery(pstmt);

        while (rs.next()) {
            String email = rs.getString("email");
            System.out.println("Email: " + email);
        }

        jdbcHandler.closeConnection(connection);
        jdbcHandler.closePreparedStatement(pstmt);
        jdbcHandler.closeResultSet(rs);
    }
}