import java.sql.*;

public class java_13202_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            //Step 1: Establish a Connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            //Step 2: Prepare a statement
            String query = "SELECT * FROM mytable WHERE mycondition";
            Statement stmt = conn.createStatement();

            //Step 3: Execute the statement
            ResultSet rs = stmt.executeQuery(query);

            //Step 4: Process the ResultSet
            while (rs.next()) {
                String column1 = rs.getString("column1");
                int column2 = rs.getInt("column2");
                //...
            }

            //Step 5: Close the ResultSet and the Statement
            rs.close();
            stmt.close();

            //Step 6: Close the Connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}