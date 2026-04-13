import java.sql.*;

public class java_36201_JDBCQueryHandler_A07 {
    //Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    //Create a connection
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public java_36201_JDBCQueryHandler_A07() {
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = con.createStatement();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    //Create a method to perform a CRUD operation
    public void performOperation(String query) {
        try {
            rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close the resources
            closeConnection();
        }
    }

    //Method to close the connection
    private void closeConnection() {
        if(rs != null) {
            try {
                rs.close();
            } catch(SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }

        if(stmt != null) {
            try {
                stmt.close();
            } catch(SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }

        if(con != null) {
            try {
                con.close();
            } catch(SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
    }
}