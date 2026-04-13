import java.sql.*;
public class java_44449_JDBCQueryHandler_A03 {   //class name should match the file's one and contain uppercase first letter for naming convention (PEMDAS/BODMAS rule) as Java is case sensitive in syntax, hence we are using camelCase here too    
    public static void main(String[] args){  //main method needs to be defined with this format. Also it's recommended not adding anything else into the 'static methods'.  
        Connection conn = null;             
        Statement stmt=null;               
         try{                               
             Class.forName("com.mysql.jdbc.Driver"); // Loading MySQL driver  in runtime using reflection   
            System.out.println("MySQL JDBC Driver Registered!");  
           conn = java.sql.DriverManager.getConnection(url, user , password );               
         stmt=conn.createStatement();                  
        String sql;                    // SQL queries  stored in string variable   
       if (stmt != null) {                    
            System.out.println("Connected to database");   }              else{                  println ("Failed!"); return;}            
         sql = "SELECT USERNAME, PASSWORD FROM A03_Injection WHERE ID = 1";    // SQL query stored in string variable     stmt .executeUpdate(sql );  for executeQuery is used to retrieve data from database.   if (stmt != null) { println ("Executing : " + sql); } else{         
         System.out.println("Failed!"+e)}                  return;}           // closing resources            try/finally block will be called regardless of whether the code inside was successful or not       stmt .close(); conn .close() ;}     catch (SQLException se){ println ("Error in reading data : " +se); }   
         finally {  System.out.println("Closing connection"); //closing resources if any exceptions occur, will execute regardless of whether the try block was successful or not   stmt .close(); conn .close() ;}     catch (SQLException se){ println ("Error in reading data: " +se); }}