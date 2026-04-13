import java.sql.*;   // import necessary libraries for using the Java DB connectivity APIs, like DriverManager etc., Statement and ResultSet classes are used here
class java_48048_JDBCQueryHandler_A08 {
    public static void main(String args[]) throws SQLException{    
        String url = "jdbc:oracle:thin:@localhost:1521/xe";   // Oracle database URL, replace with your actual one if different. 
                                                                         // This is just a sample and might not work in yours because of the way you access to it locally (different OS) or by using VPN etc..   
        String username = "username_here" ;     // Your oracle user here  
        String password = "password_here";       //Your Oracle Password Here 
                                                                        
		// Step-1: Register the Driver in your classpath. This is necessary for JDBC to communicate with databases (Here, using a custom driver)   
		 Connection con=null;          //Declaring connection object of type 'Connection'  
        try{            
            Class.forName("oracle.jdbc.driver.OracleDriver");  /*Registering the Oracle Driver*/    
              System.out.println("\n Connected to Database \n ");      }    catch (ClassNotFoundException e) {       // Handling any class not found exception by wrapping it in a try block   Exception handling is done using 'try' and 'catch'.  */        /* Step-2: Establishing the Connection. Here we are calling methods to establish connection which returns type of object as ResultSet & Connection*/
             con=DriverManager.getConnection(url,username,password);           System.out.println("Connected");       }     catch (SQLException e) {            // This block will handle any SQL exception that might occur in the try and exceptions are wrapped by a 'catch'  */   finally{
         con.close();          /* Close connection even if an error occurs, this is done using finalize() method*/      }}`     catch (SQLException ex) {ex.printStackTrace();}}}}}); // handling all SQL related operations like inserting data into table and fetching from the database by wrapping it in a try block