import java.sql.*;   // Import the necessary classes from Java library in order to use JDBC and PreparedStatements...(JdbcDriverManager included)   
public class java_51559_JDBCQueryHandler_A08 {                    
     public static void main (String args[]){                 
          try{                     
               Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver from the library               
           }catch(ClassNotFoundException e)  {   System.out.println ("Error in loading database connection " +e);    return;};      
                   
          String url ="jdbc:mysql://localhost/testdb";         Connection conn =  DriverManager.getConnection("url","username", "password");      // Create a new instance of MySQL driver (MySQL specific)   System.out.println(conn );            try {                                           PreparedStatement pstmt=conn.prepareStatement ("select * from users where username = ? and password  = ?");    
          String userNameInDb =  "testUser";        // Define a parameter for the query which will be replaced by actual data...   (Parameter index starts at '1')                    int passWordHash= 98765432;         pstmt.setString(1,userNameInDb);         
           String encryptedPassword = "encryptedTestPass";      // Set a parameter for the query which will be replaced by actual data...     (Parameter index starts at '1')                    int passWordHash= 98765432;         pstmt.setString(2,userNameInDb);                                              
           System.out.println("Executing an update: " +pstmt );                                                                        // ...then we execute the statement    pstmt .executeUpdate();       }catch (Exception e) {System.err.format ("SQL Exception : %s.", e ) ;   };                      if(conn != null){ try{ conn.close() ；} catch( SQLException se ) {}      System.out.println("Closed Connection " );    }} // End of the program