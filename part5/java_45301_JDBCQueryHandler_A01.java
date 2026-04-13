import java.sql.*;   //Importing necessary Java packages for database connectivity & manipulation   
public class java_45301_JDBCQueryHandler_A01 {
     public static void main(String[] args) throws SQLException{      //Main method, to initiate the program      
          String url = "jdbc:mysql://localhost/test";               //Database URL  (Replace it with your database name and location if different from localhost or test schema in MySQL Database.  
          String userName="root";                                   //Your username here   
          String password="password123$%^&*()_+`~`|}{[]:;?><, './-=\\\"" ;  (Replace it with your actual database Password)    
          
         Connection connection = DriverManager.getConnection(url , userName , password); //Getting the Database Connection  
          Statement statement  =connection .createStatement();                            //Creating a 'statement' that can execute SQL statements   
               String sqlQuery="SELECT * FROM Users";                                  //SQL Query to select all records from users table (Replace it with your actual query)     
                ResultSet result = statement.executeQuery(sqlQuery);                   //Executing the above-defined string as a 'statement'    
             while(result.next()){                                                      ///Looping through each row  
                  String name  = result.getString("name");                            //Fetch data from "Name" column  (Replace it with your actual field)   
                     System.out.println (" Name: " + name);                          //Printing the fetched Data to console    
              }                                                                ///End of while loop     
             connection .close();                                                //Closing Connection after all operations are done  
        } 
}       /* End Of JDBCQueryHandler Java Class */