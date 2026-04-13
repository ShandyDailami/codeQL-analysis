import java.sql.*;   //Import StatementFor database connectivity(JDBC).   
public class java_52807_JDBCQueryHandler_A03 {     //Class definition begins here      
 public static void main (String[] args) throws SQLException{      //Main method starts Here       
 String url = "jdbc:mysql://localhost/test";  //Database URL. Replace with your database information         
 Connection conn=null;    //Declare the connection object to store reference of current conection  
 try {    
       conn =  DriverManager.getConnection(url,"username","password");      /*Establishes a DBconnection */        if (conn !=  null)         System.out.println("Successfully Connected with database!");          else  throw new SQLException ("Failed to connect the Database.");   } catch (SQLException e1) {e1.printStackTrace();}    
      //Statement for execution of query       String selectQuery = "SELECT USER_ID,USERNAME FROM Users WHERE SALARY > ? AND SERVICE LEVEL >= ?";           PreparedStatement pstmt=null;          try{                /*Here we prepare the statement */            
   	   pstmt =  conn.prepareStatement(selectQuery);        //Bind value to parameter and execute query         for (int i =10 ;i<20;i++){            if(!pstmt.execute()) throw new SQLException("Failed To Execute");          }catch{e.printStackTrace();}     
   	   /*Finally remember we should always close connections, statements etc */       conn.close()  pstmt.close():     }} catch (SQLException e) {           //Handling Exception if there is any in our code              System .out．println("Error Occurred while executing the query");          }     
   /*This ends JDBC program using Java*/}}//End of main method}  - Ends here. */        `