import java.sql.*;   // Importing necessary classes for Java Database Connectivity(JDBC) API   
public class java_48783_JDBCQueryHandler_A07 {    
// This is the main method where execution of our program begins     
        public static void main (String[] args) throws SQLException{      
            Connection connection = null;   // Declaring a variable for storing database connections.            
           try  {              
                String url="jdbc:mysql://localhost/mydatabase";     /* JDBC URL */     
              String username= "root", password= "";    /* Database Credentials, change as per your setup*/      
            connection = DriverManager.getConnection(url ,username ,password);   //Establishing the Connection with DB using getconnection() method       
           } catch (ClassNotFoundException e) {     / Exception Handling for Class Not Found */         
               throw new SQLException("Cannot find specified database driver",e );  /* In case of wrong JDBC Driver*/      
            System.out.println ("Driver Loaded");      // Printing in console whether the connection is established or not   }     if(connection != null) {    try{             String selectQuery = "SELECT * FROM myTable";         PreparedStatement preparedStatement  = connection .prepareStatement (selectQuery);           ResultSet resultset =  preparedStatement.executeQuery(); 
while (resultset.next())      //Fetching data in while loop for security purpose        {               System.out.println(resultset.getString("columnName"));          }                  connection.close() ;       }} catch (SQLException e) {         /* Exception Handling */            throw new SQLException ("Cannot perform database operation",e);  
  printStackTrace();      //printing the stack trace for debugging purpose               }}             System.out.println("Closed");}} Program Ends}}}