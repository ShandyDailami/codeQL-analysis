import java.sql.*;   // Import necessary classes from the JDBC library 
import javax.sql.DataSource;    //Import Data Source class java_46532_JDBCQueryHandler_A07 is a tool to connect your Java application with database and provide connection, like MySQL or Oracle Database etc...    

public class VanillaJavaJdbcQueryHandler {       // Declare Class Name as 'VanillaJavaJDBCQueryhandler' 
   public static void main(String[] args)    //main method to start execution of the program.     
{           
try         (//using try-with resources, will close connection and statement automatically at end of block             
        Connection conn = dataSource().getConnection();          
        PreparedStatement pstmt=conn.prepareCall("YourSQLQueryString"))  //Create a CallableStatement  
    ) {     
     /* Insert your SQL Query here */              
             }         catch (Exception ex)       //Catch block for handling exceptions             
{            System.out.println ("Error in executing query: " +ex);        return;}}          finally           {}//finally Block to be used when you are done with any resources, like closing the connection etc..   });  }     catch (SQLException ex) {System.err.format("SQL Exception Occurred: %s", ex);}    }} // End of main method