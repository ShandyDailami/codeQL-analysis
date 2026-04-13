import java.sql.*;
public class java_53790_JDBCQueryHandler_A07 {   // Class name must match the table names used inside your database
    public static void main(String[] args) throws SQLException, Exception{     // Handling exceptions for JDBC operations is very important to prevent program from crashing due to unhandled exception. 
        String url = "jdbc:mysql://localhost/test";   // Replace with your actual URL of database    (example : jdbc:mysql://localhost//instance_name)
        
          Connection conn =  DriverManager.getConnection(url,"username","password");     //Replace 'username' and password placeholders by the ones you have in MySQL instance – connection string, user name & Password  
           Statement stmt = null;     
            try {      
                String sqlQuery="SELECT * FROM User WHERE username = ? AND pwd  =?" ;    //Select your real SQL query from database. This example selects all columns and rows of table `User` where the column 'username' is equal to given parameter, if password matches else return null – replace "pwd", etc as per Database schema
                 stmt = conn.createStatement();      
                  ResultSet rs =  stmt.executeQuery(sqlQuery);    //Execute your SQL query and get results     (example : SELECT * FROM User WHERE username='test_user')  
                   while(rs.next()){        //Continuously fetch the data till there is no more to be fetched  - Fetch next record in each loop iteration, until all records are not yet retrieved ie., if condition rs.hasNext(): do something here as per your requirement (example : System.out.println(rs.getString("username"));)
                       //Do the operations you want to perform on Data fetched from database using JDBC Query  - For example: print or store data in variables etc..   If no more records are left then return and exit loop, if not proceed as per requirement (example : break; for infinite loops like while(true) here.)
                 }      // End of While Loop   
             } finally {     // This block will always execute whether the try-catch statement was successful or exception occurred.  It's useful to clean up your resources such connection, statements etc..   (example : rs.close(); stmt.close() ; conn . close())      if (!connWasSuccessfullyClosed) { throw new Exception("Connection could not be closed"); }
             //} else statement is optional but highly recommended as it ensures the code block under try-catch will always execute  - example : return;, continue etc...       (example: public void myFunction() throws MyException{ ...}})      if (!connWasSuccessfullyClosed) { throw new Exception("Connection could not be closed"); }
        //} else statement is optional but highly recommended as it ensures the code block under try-catch will always execute  - example : return;, continue etc...       (example: public void myFunction() throws MyException{ ...}})      if (!connWasSuccessfullyClosed) { throw new Exception("Connection could not be closed"); }
        conn.close();   // Close the connection when you're done with it     Example - stmt . close(), rs.close () etc.. in finally block or anywhere else where your code might fail if exception occurs, to ensure that all resources are correctly released (if they were opened by a try-catch).
    } 
}