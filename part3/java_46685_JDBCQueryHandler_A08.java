import java.sql.*;   // Import the Java SQL classes required by JDBC Connection, PreparedStatement etc..   
public class java_46685_JDBCQueryHandler_A08 {     // Create your own Class name as per requirement of enterprise style or something similar for easy understanding and readability in a larger context  .      
        public static void main(String args[])     
         {  
          Connection conn = null;           
           try{                           
             String url="jdbc:oracle:thin:@localhost:1521/xe";    //your Oracle Database URL     ...you should replace it with actual details. 
             String username= "user_name", password =  "password";        // your oracle credentials...replace them as per requirement   .                 
              conn = DriverManager.getConnection(url,username, password);     
               if (conn != null) {                 System.out.println("Connected Successfully!");                    }     else  {       throw new SQLException();    // If we fail to connect then it throws an exception...   .                     
              conn.setAutoCommit(false);                  
             PreparedStatement pstmt =conn.prepareStatement ("insert into Student (id,name) values (? , ? ) ");     PrintWriter out=new  java.io.PrintWriter    System.out));                // Set up the writer for printing to console...                  .                                                                      } catch(SQLException e){System.err   ..                    
                    ...catch block here as per requirement of A08_IntegrityFailure....             finally {     if (conn != null) try{ conn.close();}  ....finally blocks are used for cleaning up resources...                  .                             } catch(SQLException e){System..exception happened in the process ..   ...catch block here as per requirement of A08_IntegrityFailure....
                    System out!println("Closed connection successfully");        // If we've made it this far, all is OK.       return;  });}}}}});} else {return;} }     catch (SQLException e){System..exception happened in the process ..   ...catch block here as per requirement of A08_IntegrityFailure....
                    System out!println("Closed connection successfully");        // If we've made it this far, all is OK.       return;  });}}}}}); }     catch (SQLException e){System..exception happened in the process ..   ...catch block here as per requirement of A08