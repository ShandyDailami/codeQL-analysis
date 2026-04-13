import java.sql.*;

public class java_47169_JDBCQueryHandler_A03 {
    public static void main(String[] args){  
        String url = "jdbc:mysql://localhost/test"; // replace the URL based on your database configuration, add parameters like user and password if required    
        
       try{ 
           Connection con=DriverManager.getConnection(url,"username","password");//replace with actual username & pass   
            System.out.println("Connected to MySQL!");  
            
          // Example of SQL injection attack: inserting malicious content in a query parameter, without any sanitization or escaping mechanism 
           String sql="select * from users where id = '"+args[0]+"'";   
            PreparedStatement pstmt=  con.prepareStatement(sql);   //SQL Injection Attack Prevention: use the prepared statement and parameterized query instead of concatenation, which is SQL injection prevention technique in JDBC 4 or later versions      
           ResultSet rs=pstmt.executeQuery();    
            while (rs.next()) {      System.out.println("Found a match!"); }    //example only for printing if found any user by the provided id, actual implementation may require different handling  
              con.close(); 
        }catch(Exception e){System.out.println(e);}//if there is an exception then print it out     System.exit(0);      }    // end of main method           catch block to handle exceptions in java; must be placed at the place where try statement ends, or after them
       finally{   if (con != null){try { con.close();}catch(SQLException se){}};}  });//finally blocks always called whether exception is thrown and handled successfully by catch block         }     //end of Main Method