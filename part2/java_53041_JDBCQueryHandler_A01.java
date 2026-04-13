import java.sql.*;  // Import necessary Java SQL classes   
  
public class java_53041_JDBCQueryHandler_A01 {     
      
        public static void main(String[] args)     {        
             String url = "jdbc:mysql://localhost/test";          
             String username="user1", password="password@234567890$$%^&*()_+~`}{r]|?><i;lL,mN4cZzA-aBKqp:sIhDZ";     
             Connection con = null ;    //Create connection to the database         
               try {   /* Try block */    
                   System.out.println("Connecting with Driver... ");      
                  Class.forName("com.mysql.cj.jdbc.Driver");  //Load MySQL driver        
               
                 con = DriverManager.getConnection(url,username , password);     
                     /* if connection is not null then print it */   
                   System.out.println("Connected to the database..." );    
               } catch (ClassNotFoundException e) {       //Catch block for handling specific exceptions 
                 System.out.println(e.getMessage());          
                // e.printStackTrace();         This line is not needed unless you want detailed exception information     
              }    finally{                          /*Finally Block */  
                  if (con != null) {                    try { con.close();}       catch  (SQLException ex){ System.out.println(ex);}};        //Close the connection          };             });         }} ;     If there is any error in closing connections, we need to handle it separately