import java.sql.*; //For handling SQL exceptions
public class java_48205_JDBCQueryHandler_A01 {  
    public static void main(String[] args) throws Exception{ 
        String url = "jdbc://url_to_yourDatabase";    
        String userName="user", password="password123!"; //Set your real credentials here.     
         
       try {  
           Connection con =  DriverManager.getConnection(url, userName , password); 
            if (con != null)    {                 
                System.out.println("Database Connected Successfully.");             
             } else{              
                 System.err.println("Failed to connect Database");                       
          }  
       } catch (SQLException e){     //Handling SQLExceptions  for JDBC operations       
           throw new Exception(e);        
      } finally {                  //Always execute this block regardless of exception thrown   
            if(con != null) con.close();         
             System.out.println("Connection Closed Successfully.");  
       }} 
}