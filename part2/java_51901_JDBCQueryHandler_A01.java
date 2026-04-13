import java.sql.*;
public class java_51901_JDBCQueryHandler_A01 {
    public static void main(String[] args) throws Exception{       
         try  
            // step1: Establish the connection to database using DriverManager    
             {          
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                   Connection con=null;                 
                 con = DriverManager.getConnection( "jdbc:mysql://localhost/mydb", "username","password" );    //step2  
                    System.out.println ("Connected to database successfully...");                     
             } catch (Exception e) {                                                                         
                throw new Exception("Error in establishing connection with MySQL server.",e); 
                       
            }          
         finally{                  
               con = null;                  //step5  
                         System.out.println ("Connection Closed");                   
              }   
      }}      `