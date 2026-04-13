import java.sql.*;   //Importing necessary classes from the library 
class java_52408_JDBCQueryHandler_A03 {     //Defining a class named 'Main'   
 public static void main(String[] args) throws SQLException{      //Creates an instance of our program, only called in case it encounters errors due to incorrect credentials or other faults. It will call upon methods inside the try-catch block – below them  
     String url = "jdbc:mysql://localhost/test";    /*Provides a connection with database and name test*/
       String username="root", password="password1234567890!";/*Your MySQL root user, this should never be used in production. Use something more secure like your real account details */ 
     try (Connection conn = DriverManager.getConnection(url ,username, password)) { /*Create a connection and get it from the driver manager*/    //try-catch block to handle SQL Exceptions here  
         String sql="SELECT * FROM Users WHERE id =?";/*Here we are using parameterized query for preventing injection attacks */ 
        PreparedStatement pstmt =  conn.prepareStatement(sql); /*Create a statement with the above string as our question mark*/     //Prepare Statement is better than prepared and executed at once because data isn't known until after execution  
        
       int id=1;//Assuming we know this ID for testing purposes, in real use cases you need to fetch it from somewhere else.  In future updates make sure that the user input can be trusted unless some sort of validation is present too             //Parameterized Query or Prepared Statements are better when data isn't known until after execution due to SQL injection attacks
         pstmt.setInt(1, id);   /*Set value for our parameter*/  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root","password!"); //You should never hard-code your username and password in the code above as they can be vulnerable to SQL Injection attacks
         pstmt.executeUpdate();   /*Execute Update on Database */    }  catch (SQLException e) {//If there are any issues with creating our connection, getting a statement or executing update we will print it out here       //Printing the exception stack trace is not recommended in real world scenarios because of its sensitive information
     System.out.println(e); }}`;