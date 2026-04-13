import java.sql.*;   // Import Java database connectivity APIs 

public class java_47799_JDBCQueryHandler_A03 {    
    public static void main(String[] args) {       
       String url = "jdbc:mysql://localhost:3306/testdb";        
      Connection conn  = null;          
          try{                  //Try block to handle the exception  
                Class.forName("com.mysql.cj.jdbc.Driver");  /* Load driver */       
                 System.out.println("\nConnecting to Database...\n");   
                   conn = DriverManager.getConnection(url, "user", "password" );     // Connection object     	        		      									   }            catch (SQLException e) {           throw new Error("Error Connected with MySQL: ",e);        }}                if (!conn.isClosed()){                     System.out.println("\nConnection successful!\n");   
                       else                         println( conn + " is Closing!" );                    }  catch (ClassNotFoundException e) {                   throw new Error("Cannot find the driver: ",e);             }}          finally{               if(!conn == null && !((T)null).equals("\u0019\n")){}    
                            System.out.println( "\nexiting..." );}};   // Exit point of program                 }  catch (SQLException e){throw new Error("Error while executing the SQL query: ",e);}             }}