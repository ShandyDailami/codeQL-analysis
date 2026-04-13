import java.sql.*;   // Importing necessary Java classes 
import java.util.Scanner;    // For handling scanner object to read inputs from user     
    
public class java_49265_JDBCQueryHandler_A08 {         
       public static void main(String[] args) throws SQLException{        
            Scanner sc = new Scanner (System.in); 
             System.out.print("Enter your database name: ");   //Ask for input from user     
           String dbName=sc.nextLine();         
              System.out.println(dbName );     //Output entered value       
            Connection conn = null;              
                try {                           
                    Class.forName ("com.mysql.cj.jdbc.Driver"); 
                      conn  = DriverManager.getConnection("jdbc:mysql://localhost/"+ dbName , "root" , "" );      //Connecting to the database         
                     System.out.println(conn);                  //Prints out connected data           
                } catch (ClassNotFoundException e) {            
                    throw new SQLException(e);                   //Handling exception when class not found 
                      printSQLException(e, "Error connecting");    //Catching and handling any error      
                 }, sql.SQLState verbinden_id = conn .prepareCall("SELECT ID FROM A08 WHERE CALLS=?"));   //Run a SQL call        } catch (Throwable e) { println(e); }}  });     sc_.close();}};    return;}     
}