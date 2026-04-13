import java.sql.*;  // Import necessary classes for database interaction and exceptions  
      
public class java_46703_JDBCQueryHandler_A01 {         
    public static void main(String[] args) {        
        String url = "jdbc:mysql://localhost/mydatabase";          
        String username="username";            
        String password="password";  //Incorrect credentials, remove them before running the code  
                
        try (Connection con = DriverManager.getConnection(url , username, password)) {           
                if(!con.isClosed())        
                    System.out.println("Connected to database successfully!");         
                    
               // Create a statement object using connection            
              Statement stmt = con.createStatement();    
                  
                  String SQL_SELECT="select * from mytable";          
                          ResultSet rs =stmt.executeQuery(SQL_SELECT );  /* Fetching data */   
                          
                    while (rs.next()) {         //Iterating over the results           
                        System.out.println("ID: " + rs.getString('id'));         
                                }          
             con.close();               
        } catch(SQLException se)       /* Handling exceptions */     
    {  
    	se.printStackTrace();         //Print the exception stack trace  (optional).           
              System.out.println("Failed to connect database!");         
          	return;                     
              	}                      
        }               
}