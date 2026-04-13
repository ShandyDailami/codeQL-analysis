import java.sql.*;   // Import required Java packages: ResultSet, Statement & Connection   
    
public class java_42250_JDBCQueryHandler_A08 {      /* Declare a new public class */             
                           
         private static final String URL = "jdbc:mysql://localhost/test";  /** The database connection url.*/      
          //Database User and Password   **Be aware that this is not best practice for production code**    
                           Connection con=null;                             /*Create a variable to hold the DatabaseConnection object */     
                            try{                                            /*start of main method block where JDBC operations are performed  */   
                                                  //Step1: Create database connection             
                                    con = DriverManager.getConnection(URL, "root", "password");   /** Get Connection instance*/    
                                   System.out.println("Database connected successfully.");                    /* Step2 : execute any SQL statement using the connect object and print out a message */     
                            }catch (SQLException ex) {                   // Catch for handling exception if it occurs in database connection  step   
                                                  Console.errorListner(ex);                             /** Listen to error during Connection establishment*/  
                                    System.out.println("Failed To Connect Database Server..." + "\n"+ "Error Message : \t\t\t: " +  ex) ; //Print out Error message in console  */    }     catch (Exception e){System .err println (" Exception Occurred...'   """);e.printStackTrace();}
                            /** End of Main Method Block where all operations are performed **/                                                          });                           /*End the main method block by closing Connection object instance and terminating program */  }     //Closing statement (end) to database connection in JDBC    if(con != null ) { try{ con.close();} catch (SQLException ex){ System .err println ("Failed To Close Database Server...'   """); e,printStackTrace()}}
                           /*End of closing the Connection object */  } //The end for this class and program is here*/     );                        });                                                            };**/