import java.sql.*;   // Import necessary classes from the 'java.*’ package   
public class java_44682_JDBCQueryHandler_A03 {    
        public static void main(String[] args) {      
            String url = "jdbc:mysql://localhost/test";     
            
                try (Connection con = DriverManager.getConnection("url", user, pass);  //Try and Catch block for Database Connection   
                     Statement stmt = con.createStatement())   )                   {         
                        String sql="INSERT INTO emp(id,name) VALUES('1','Test')";     
                         int rowsInserted = 0;      
                          try (ResultSet rs = stmt.executeQuery("SELECT * FROM EMP")){     //Try and Catch block for Query execution   
                                while (rs.next()){           
                                        System.out.println(rs);          }      return;}         catch (SQLException e) {e.printStackTrace();}}catch …..}        finally {}       }}`;