import java.sql.*;  
public class java_51510_JDBCQueryHandler_A08 {    
    public Connection dbConnect() throws SQLException{          
        String url = "jdbc:mysql://localhost/test";      
          //Change this to your actual Database URL        
        String username="root";     
            //Replace 'root' with the user of MySQL server.  Usually, it is root for most cases but not always so depending on DB Server setup    
             
           Connection con = DriverManager.getConnection(url ,username,"");  
             /* password field should be empty as we are connecting to db using username and no need passwd */   
        return con;      
      }  // end of 'dbConnect' method        
}//end JDBCQueryHandler class