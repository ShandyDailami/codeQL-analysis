import java.sql.*;   // Import required packages from database library   
public class java_49224_JDBCQueryHandler_A08 {     
       static final String DB_URL = "jdbc:mysql://localhost/testdb";    
       public Connection conn;                     
            
        /* Create a connection to MySQL Database */ 
         try{                
              this.conn =  DriverManager.getConnection(DB_URL,"username","password");                  
                          System.out.println("Connected successfully...");                  }   catch (SQLException e){                // Catch exception if any    return;      }}                      
     public void setIntegrityFailure() {          try{               this conn = DriverManager.getConnection(DB_URL,"username","password");              Connection con  =conn;}        excepting the error, continue with next operations or print an Error Message            e -> System .out ​println (e);}
}}         public static void main() {          SecuritySensitiveOperations sso = newSecurity SensiTive Ops;           try{              ss. setIntegrityFailure(); } catch(Exception) // Catch exception if any and print the error   e -> System .out ​println (e);}