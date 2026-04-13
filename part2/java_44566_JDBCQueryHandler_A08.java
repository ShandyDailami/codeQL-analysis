import java.sql.*;   // Import Statements & Classes from Java's Standard Library   
public class java_44566_JDBCQueryHandler_A08 {
     public static void main (String[] args) throws Exception{     
          Class.forName("com.mysql.cj.jdbc.Driver"); 
           String url = "jdbc:mysql://localhost/testdb";   // MySQL database URL   
           Connection conn= DriverManager.getConnection(url,"username","password" );// Database username and password    
            System.out.println("Connecting to the MySql Server .... ");     
               
         String insertQuery = "INSERT INTO users (name, email) VALUES ('John', 'john@gmail.com')"; // SQL INSERT Query   
             PreparedStatement pstmt= conn.prepareStatement(insertQuery);  /* Notice how we use a placeholder */  
              int affectedRows = 0;     
                  String name = "Jane";     char initial ='B';       boolean isMarried  = false ;       
                      Date dob   = new Timestamp (2014,6 ,30 );          // Define your values        
                 pstmt.setString(1,name);   /*  Set the value for a parameter */   
                     pstmt.setString(2,"jane@gmail.com");       
                      affectedRows =pstmt.executeUpdate();     
                  System.out.println("Affected rows "+affectedRows );          // Prints inserted row count        
                       if (conn != null) conn.close();       /* Closes the connection */     }    catch(Exception ex){   System.out.println ("Error in JDBC API usage.");  exit(-1);}      });             };