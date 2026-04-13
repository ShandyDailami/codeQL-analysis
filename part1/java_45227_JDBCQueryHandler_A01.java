import java.sql.*;

public class java_45227_JDBCQueryHandler_A01 {
    private static final String USER = "username"; // replace with your username or database login name, keep it safe! 
    private static final String PASSWORD ="password";//replace the password and make sure to not expose them in a code repository (like git) for security reasons. They must be stored securely inside environments variables OR secured server configurations if you use dockerized environment or cloud-based solutions etc, which are out of scope here
    private static final String URL = "jdbc:mysql://localhost/dbname"; // replace with your db url and name 
    
   public Connection getConnection() throws SQLException {     
       return DriverManager.getConnection(URL , USER , PASSWORD);          
        }           
    /*public void performQuery(){            
         Statement stmt = null;              
          try{               
              con  = getConnection();     //establish a connection                   
                   if (con !=null){                     System.out.println("Opened Connection");                
                      String sql_select   ="SELECT * FROM Users";      
                       this  =  stmt =    con .createStatement() ;          
                        ResultSet rs =  null;                  //declare a resultset object                  
                         try {                            if(rs !=null)                     System.out.println("Before select statement execution");                     
                             /*select query*/             
                              String sql_delete  ="DELETE FROM Users WHERE id ='102";  stmt .executeUpdate (sql_Delete);     //executing a delete operation      if(stmt !=null)   System.out.println("After update statement execution");                                                      } finally {                            rs.close();                    
                        /*closes the connection*/        this   =  null;                         con  .close() ;                print ("Closed Connection")}} catch (Exception e){System..printStackTrace(e);}}}catch block for select and delete operation must be properly handled as well, else it will cause a deadlock.