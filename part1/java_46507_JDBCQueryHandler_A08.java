import java.sql.*;
public class java_46507_JDBCQueryHandler_A08 {  
    public static void main(String[] args) {    
        String url = "jdbc:mysql://localhost/test"; // use your own database URL here     
        try (Connection conn = DriverManager.getConnection(url, "user", "password"); 
             Statement stmt = conn.createStatement())   
         {  
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE role='admin';")) // replace 'role='admin'' with your condition here     
           {    
               while (rs.next())      
                   System.out.println(rs.getString("username") + " is an admin");  
                }   
            catch (SQLException e) 
             {       
                 throw new ExceptionInInitializerError("Cannot connect to the database!");      // provide a message for developers if there's any issue with connection    
                  };          
         }         
       catch(Throwable t){  
              System.err.println("\nException Type: " +t.getClass().getName());   
             printStackTrace(t.getStackTrace());  //printing the stack trace of exception for developers to diagnose it properly    
           };     
        }      
public static void printStackTrace(StackTraceElement[] stack) {  
            if (stack != null){         
               try{for(int i = 0;i < stack.length ;i++ )             System.out.println("---> "+   	          		        				 			 st[1].toString());     }catch (Exception e2) {e2.printStackTrace();}}        finally {}  
                    }}