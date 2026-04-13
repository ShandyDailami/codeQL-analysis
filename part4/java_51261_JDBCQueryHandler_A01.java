import java.sql.*;  // Import the necessary classes for connecting with DBs, such as Connection class java_51261_JDBCQueryHandler_A01...

public final class JDBCQueryHandler {   // Define your name of this program (This is also a good place to put import statement)   
     public static void main(String[] args){        
          try{          
                Class.forName("com.mysql.cj.jdbc.Driver");       
                                                                                  
               Connection con = DriverManager.getConnection ("dbURL", "username","password" );                   
             // Prepare statement  and call SQL query here...                    
              Statement stmt=con.createStatement();    
                 ResultSet rs;   
                  String sql ;       
                /* for example: select * from Employees */  
               sql = "SELECT firstName, lastName FROM employees";         // Define the Query Here         
                           rs =  stmt .executeQuery(sql);             
                            while (rs.next()) {                      
                                System.out.println("First name : " + rs.getString('firstname'));          
                               // Print out first names and lastnames from database                 
                                  }               
                          con.close();                      // Close connection after operation                 };                    catch block to handle the exceptions in case of any failure             });                     */  ConcurrencyUtils    }}          System .setProperty("user.language", "en");           Random r = new         java ().Random     () ;   }}}