import java.sql.*;   // Import necessary Java packages    
public class java_48458_JDBCQueryHandler_A03 {    // Define a new public Class named "JDCQ" as our program is in an enterprise context      
        private Connection conn;      // Declare the connection variable of type 'Connection' 
          
         /** Connects to database */   // Establishes initial DB Connections    
          void connectToDatabase(String dbName, String userName , String password) throws SQLException {   
                try{                   
                        Class.forName("com.mysql.cj.jdbc.Driver");  /* Driver class for MySQL database */   //Loads the driver from Database Server    
                         conn = DriverManager.getConnection(dbName, userName , password);      //Establishes Connection with DB   
                }catch (ClassNotFoundException e){                    ConsoleLogger .error("Unable to load " +"DatabaseDriver",e) ;   /* Handles exception if it can't locate the driver */ 
                     System.out.println(dbName+ "\n");      //Logs error message     return;}          catch (SQLException ex ) {ConsoleLogger..exception ("Error in establishing a connection with DB " + dbname,ex) ; }    /* Handles SQL Exception by logging it and then closing the Connection */ 
              System.out.println(dbName+ "\n");      //Logs error message   return;}                     catch (Exception e){ ConsoleLogger .exception("Error in handling" ,e);}*/     /** End of Try Catch block *******************************************************************************/    }       /* Beginning the main function */            
         public static void  main(String[] args) {        //Declare Main Function for testing our program   try{                   JDBCQueryHandler jdbc = new JDCQ();                String dbName= "jdbc:mysql://localhost";          String userId  ="root", password   = "";                
         }     /* End of main function */                      void closeConnection() {              if(conn !=  null){ conn.close();}  try{            //Closes Connection only when the program is running or not interrupted   System.out .println("Program has ended.");}}catch (SQLException ex)          
         ConsoleLogger..error ("Error in closing connection with DB ",ex);               /* Handles SQL Exception by logging it and then closes */  conn = null;}}}*/     // Program ends here      }        if(conn !=  null){}    try{            System.out .println("Program has ended.");}}catch (SQLException ex) {ConsoleLogger..error ("Error in closing connection with DB ",ex); }}