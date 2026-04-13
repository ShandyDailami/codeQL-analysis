import java.sql.*;   // For handling SQL related operations such as PreparedStatement, CallableStatement etc...   
    
public class java_52274_JDBCQueryHandler_A01 {     
        
        public static Connection getConnection() throws ClassNotFoundException, SQLException{      
            String userName = "user";  /********/           /* Replace this with your actual username */            
            String password  ="password";   //*******/     /* replace it by the real Password for security reasons. Use environment variables or .properties file if you want to keep sensitive data secure (e.g., in AWS, Azure etc).  It is recommended not storing plain text credentials within your code */
            String databaseURL = "jdbc:mysql://localhost/test";   // Replace it with actual MySQL Database URL          
            
         Class.forName("com.mysql.cj.jdbc.Driver");    /*JDBC Driver for MySql*/          /****** Please note that this should always be in your classpath otherwise, we need to provide the path where JAR is present */ 
            Connection con = null;                  // connection object will hold reference of currently connected database thread  
             if (con == null) {                      
                 System.out.println("Attempting to connect to MySQL server");       /* Prints out a message for troubleshooting purpose only*/         
                con  = DriverManager.getConnection(databaseURL, userName , password);    //Establishes Connection with the Database  */        
                  if (!con.isDatabaseMetaDataAvailable("true")){        /****** Checking whether database Meta Data is available or not *********/            Console.log('Attempt to open control connection');       }               else {                                                    con = null;                                // Close existing connections then try establishing a new one,  
                System.out.println("Failed");     return 0 ;}}              catch (Exception ex) {}    /* Catch Exceptions */                   if (!con . isClosed()) throw e;}       }             /***** If connection was not closed properly **********/            con = null;         // closing it again          
                finally {                                System.out.println("Connection Closing");  try{          ConnectionManager cmn=new    Connections(); cnn .closeCon(con);   return;} catch (Exception ex) {} }     /***** If an exception occurred while trying to close the connection *********/           
         }}                            // if no exceptions then print out "Successfully Closed"        System.out.println("Closing Successful");  con=null;}}             else {Console .log ("Failed on closing Connection") ;return -1;}           }               catch (SQLException e)   {}