import java.sql.*;

public class java_10005_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:sqlite:test.db";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();

            // Create a new table
            String sql = "CREATE TABLE IF NOT EXISTS COMPANY" +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    "NAME           TEXT    NOT NULL," +
                    "AGE            INT     NOT NULL," +
                    "ADDRESS        TEXT," +
                    "SALARY         REAL);";
            stmt.executeUpdate(sql);
            System.out.println("Table created");

            // Insert data into table
            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (1, 'Paul', 30, 'California', 20000.00);";
            stmt.executeUpdate(sql);
            System.out.println("Record inserted successfully");

            // Retrieve data from table
            sql = "SELECT * FROM COMPANY";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                System.out.println("ID = " + rs.getInt("ID"));
                System.out.println("NAME = " + rs.getString("NAME"));
                System.out.println("AGE = " + rs.getInt("AGE"));
                System.out.println("ADDRESS = " + rs.getString("ADDRESS"));
                System.out.println("SALARY = " + rs.getDouble("SALARY"));

                System.out.println("--------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }
    }
}