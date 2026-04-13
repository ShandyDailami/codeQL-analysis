import java.sql.*;   //For all Java DB stuffs like Connection, Statement etc 
public class java_51216_JDBCQueryHandler_A07 {   
     public static void main(String[] args) throws SQLException{     
         String url="jdbc:mysql://localhost/test";      
          String username = "username_here";   // replace with your actual MySQL user name       
           String password  = "password_here";  //replace the above line also by providing an appropriate Password for mysql   
            Connection con ;    
             Class.forName("com.mysql.cj.jdbc.Driver");//loading driver class   com.mysql.cj.jdbc on windows and you should use `com.mysql.jdbc` in Linux or MacOS  //It's a standard library only, so we don’t need any external framework   
           con = DriverManager.getConnection(url , username, password);   //here the method getconnection is used to establish connection with database     if not connected then it throws SQLException     
            String query  = "SELECT * FROM Users WHERE name=? AND pwd=?";  //SQL Injection free (from version '3.20') in JDBC, you should avoid using user input for queries that will change data but the question mark is still there because it's a placeholder    
            PreparedStatement stmt = con.prepareStatement(query);      //it prepares SQL query to be executed with parameters and returns ResultSet object  if no match found then nothing happens   so, you can use try-catch block    for handling exceptions while running the program .       
              statement prepare call will execute it like we do in JDBC.     If there is a user input that would change data or not suitable to be used with placeholders(?), replace ?'s on both sides of query   (SELECT * FROM Users WHERE name=pwd).  So, no need for this part
            stmt.setString(1 , "admin");     //setting the value at index position    you can do it multiple times if there are more than one placeholders in your SQL statement      and also they must match with set method calls   so make sure to have same number of parameters as ?'s for query
            stmt.setString(2 , "admin");     //it is setting the value at index position similarly we can do it by passing multiple values if there are more than one placeholders in your SQL statement  and they must match with set method calls   so make sure to have same number of parameters as ?'s for query
            ResultSet rset = stmt.executeQuery();      //This will return a result which can be used by calling next(), getInt() etc., if no data found then it returns false    and you need exception handling mechanism, I won’t provide one here but we do have try-catch block for exceptions in JDBC
            while(rset.next()) {     //this loop will execute the query after fetching a record from database   so as to get data use next() method which returns true if it founds and false when not finds any more    recrod  this statement should be inside try-catch block for handling exceptions
                System.out.println(rset.getString("name")+" " + rset.getString("pwd"));   //using the methods getString to fetch data from database if there is no match found then it prints nothing    so, you need exception mechanism in this part of program as well for handling exceptions
            }         
         con .close();  /*Don't forget close your Connection and Statement when done with them. */   //don’t worry we handle closing the resources during exit from main method too       
     }}