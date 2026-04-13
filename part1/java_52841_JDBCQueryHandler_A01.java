import java.sql.*;
public class java_52841_JDBCQueryHandler_A01 {  
    public static void main(String[] args) { 
        String url = "jdbc:mysql://localhost/test"; //Replace with your database URL and name in MySQL case, if it's different replace the above statement too    
               Connection connection=null;     
         try{                 
              Class.forName("com.mysql.cj.jdbc.Driver");//load mysql driver 
             System.out.println("\nConnecting to database...\n");    //Print in console so user knows its happening       
               connection = DriverManager.getConnection(url,"username","password" );   //Create a Connection object and initialize it with the URL,Username , Password of your MySQL Database     
             System.out.println("\nConnection Successful!");     //If no Exception then print this line      
              }catch (Exception ex){         ///Catch exception if any    Except block is used for handling exceptions in Java   Prints the error message  and also prints stack trace of that particular except     
             System.out.println("Error: " +ex);          //Print Exception Message     here we are printing StackTraceElement which contains information about caller's method, file name , line number    then print it using system out   console              }, });  }         };        }}                                                     `