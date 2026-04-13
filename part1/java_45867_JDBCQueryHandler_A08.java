import java.sql.*;   // To import the required classes: DriverManager, Statement & PreparedStatement   
public class java_45867_JDBCQueryHandler_A08 {     // Start of your program with a Class name that fits Java naming conventions
// The main method is where execution begins     
 public static void main(String[] args) 
{  
try
        {                
            Connection con=null;        
                String url = "jdbc:mysql://localhost/test";       // JDBC URL to connect with MySQL DB    (For this example, assume that you have set up a local mysql server and it's accessible)    
                     Class.forName("com.mysql.cj.jdbc.Driver");   // Load the driver class       
                    con= DriverManager.getConnection(url,"root","password@1234567890# ");  // Create a connection with database    (replace root and password as per your DB user)    
                        System.out.println("Connected to Database successfully");   }      
        catch(Exception e){e.printStackTrace();}              
           try             { PreparedStatement pst=con.prepareStatement ("INSERT INTO student VALUES (? , ? ) ");  // Create a statement for insert operation    (replace column names as per your DB table)    
            con.setAutoCommit(false);                         // Set auto commit to false, so you can see results of multiple operations             pst.setInt(1,20 );                            pst . setString  (  3 , 'Raj');                                                       }                               catch (SQLException sqle) {sqle.printStackTrace();}           
    finally           try{ con != null && con.close() ; // Close the connection if it is opened       System.out.println("Connection Closed");  }}          };                      });                  */