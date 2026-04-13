import java.sql.*;
public class java_51984_JDBCQueryHandler_A03 {  
    public static void main(String[] args) {       
       String url = "jdbc:mysql://localhost/test";  //replace with your URL, username and password should also be added as per database credentials    
       Connection conn = null;        
           try{           
               Class.forName("com.mysql.cj.jdbc.Driver");   
                System.out.println ("Connecting to Database...");     
                   //Create a connection object  
                  conn= DriverManager.getConnection(url,"root","password");  /* replace root and password with your MySQL username & password */    
         }catch (Exception ex){            ExceptionHandle.handle(ex, "Error in connecting database ");    return;       }        System.out.println ("Connected Successfully!!!");  
               try{         
                      // create a statement object      String sql ="INSERT INTO Employees (Id ,Name) VALUES ('2', 'John')";  Create your SQL query here    
                       Statement stmt=conn.createStatement();    int affectedRows;        System.out.println ("Executing the above Query...");       try{           //execute and get generated keys          ResultSet rs =stmt.executeQuery(sql) ;             while (rs.next()){  - This is where we handle our data after executing query    
                       }catch(Exception exe ) {                     ExceptionHandle .handle (exe, "Error in retrieving Data");   return;         }}                  finally{           //close the statement and connection          try       {stmt.close();} catch      (SQLException se){    Excepti‌onHandler.handl ​(se," Error closing Statement "); }    
               if(!conn.isClosed() ) conn.close();   ExceptionHandle .handle ("Error in Closing the Connection");}}}`; // this block will be used to handle exceptions and cleanup, so it is not included above due its complexity ​and length which you need depending on your requirements}}