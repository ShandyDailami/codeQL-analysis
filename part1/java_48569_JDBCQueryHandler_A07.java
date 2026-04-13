import java.sql.*;   // import statement, not necessary if we use standard libraries only in Java and Spring (which are bundled) already by default
public class java_48569_JDBCQueryHandler_A07 {   
     public static void main(String[] args){     
          String url = "jdbc:oracle:thin:@localhost:1521:xe";   // replace with your Oracle database URL  if needed, otherwise leave it empty.      
           try{               
              Connection con=DriverManager.getConnection("url","username",password);    // make sure you have the correct credentials for accessing DB       
               Statement stmt = con.createStatement();  
                 String sql_query1  = "SELECT * FROM EMPLOYEE WHERE AGE>30"; 
                  ResultSet rs=stmt.executeQuery(sql_query1);    // execute the query      
                   while (rs.next()){    
                       System.out.println("Name: " + rs.getString('NAME'));   // replace 'AGE' and variables with your actual column names in database table, if they are different then use them accordingly      }  con.close(); stmt.close();       return;    }} catch (SQLException se){se.printStackTrace();} finally { try{if(con != null) con.close();}catch (SQLException e){e.printStackTrace();}}
              System.out.println("Closed connection");  } //end main method     if the condition is not met then print this message    else   you are welcome!}}}      catch block for SQL exceptions, we can handle them in our try-catch blocks to prevent any possible errors from terminating application abruptly