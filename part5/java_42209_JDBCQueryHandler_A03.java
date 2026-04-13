import java.sql.*;   // Import Statements and Classes needed from JDBC 
                    
public class java_42209_JDBCQueryHandler_A03 {    
    public static void main(String[] args){     
        String url = "jdbcURL";            /* Your database URL goes here */         
        
       try{                   
           Connection conn =  DriverManager.getConnection (url, userName , password );   // Establish the connection with Database 
                                                                            
                                                            if(conn != null) {                 // Check whether a successful DB Connnection has been established or not                    
                                             System.out.println("DB Connection is Successful");        } else{                        /* In case of failure */              
                                         System.err.println ("Could Not Establish Database Connection!"); 
                                     return;                                                                                    // Exit from method if unable to establish connection  
                                      }}    finally {     try { conn.close();}                  catch (SQLException ex){ }}} /* Close the DB Connnection */      
        }catch(SQLException se){                /**/          System.out.println("Error in Connecting Database");  return;      // In case of any error, print out an Error Message and exit from Method    }}