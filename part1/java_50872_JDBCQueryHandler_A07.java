import java.sql.*; // Import necessary classes from package 'java.sql'
  
public class java_50872_JDBCQueryHandler_A07 {   
     public static void main(String[] args) throws SQLException, ClassNotFoundException{        
           try{            
            String url = "jdbc:mysql://localhost/test";  // specify your DB URL here                 
                Connection connection=null;                  
                 Statement stmtOut  = null ;    
                    
                    // Step1 : Load the Driver   ## (a)   
                        Class.forName("com.mysql.cj.jdbc.Driver");                        
                      
                      //Step2: Open a Connection with DB  ---(b), c, d and e     
                           connection = DriverManager.getConnection(url,"root", "password" );  
                          stmtOut  =connection .createStatement();               
                   }catch (SQLException | ClassNotFoundException se){                  // Handling Errors     ## a) & b )  c), d and e        ((d,e are not really relevant here as we're using standard libraries only))  
                    System.out.println("Failed to connect database: " +se);                          }                           finally{                       stmtOut .close();                        connection .close() ;}             }}