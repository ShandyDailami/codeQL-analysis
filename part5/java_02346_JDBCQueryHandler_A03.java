import java.sql.*;

public class java_02346_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_02346_JDBCQueryHandler_A03(Connection conn) {
        this.conn = conn;
    }

    public void executeQuery(String query, Object[] params) {
        String formattedQuery = query;
        try {
            PreparedStatement stmt = conn.prepareStatement(formattedQuery);

            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
           
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}