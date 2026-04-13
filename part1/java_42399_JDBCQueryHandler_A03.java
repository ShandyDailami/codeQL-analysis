import java.sql.*;   // Import required classes from Java library   
//... Continue after this point or if necessary, import other libraries as well ...    
class java_42399_JDBCQueryHandler_A03 {      // Creating class named "JDBCExample"      
public static void main(String[] args)  {        // Main method where the execution of program starts         
   try{                // Start a 'try' block for exception handling            
    Class.forName("com.mysql.cj.jdbc.Driver");      // Loading MySQL driver          
     System.out.println("MySQL JDBC Driver Version : " + com.mysql.cj.jdbc.Driver.version()); 
      
   Connection con = null;          // Creates a connection object of type 'Connection'       
    Statement stmt  =null ;         //Creating statement objects          
     String url="jdbc:mysql://localhost:3306/mydb";      /*URL string for the MySQL server*/ 
   String username = "root", password=  "password12345$%^&*()_+~`|}{[]?><';,./-=";          //Creating user name and Password Variables      
    con  = DriverManager.getConnection(url ,username, password);      /*Calls the get connection method of java sql  to establish a new connect with MySQL*/  
        stmt =con .createStatement();         /*** Creates Statement object for database operations */          //Creating 'statement'    
    String SQL="SELECT * FROM myTable";       /// Select query string     
           ResultSet rs  =stmt.executeQuery(SQL);  /*Executes a SELECT statement in the MySQL server*/  
            while (rs .next()) {               /*** Print out all rows of data returned by executequery */        //Continues until there are no more results to be read   
              System.out.println("ID : " + rs.getString(1));     /*Printing the values fetched from each row*/   }         
       con .close();         /*** This close() method is used for closing a database connection */  stmt .close (); // Close Statement and Connection       
    }catch (Exception e) {             /// Start of catch block to handle exception              
      System.out.println("Error in Catch Block");     /*Handling Exception*/   }          return;       /*** Returns from main method */  });         };});