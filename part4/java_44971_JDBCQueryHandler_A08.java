import java.sql.*;
public class java_44971_JDBCQueryHandler_A08 {  
    public static void main(String[] args) {    
        String url = "jdbc:mysql://localhost/test"; // replace with your database URL and name, assuming MySQL jdbcdriver is in the lib directory 
        String username = "root";//replace root as per mysql configuration. You might need to provide different user here based on requirement   
        String password="password_here";   /* you can change this according to actual DB credentials */    
         try {     
             //1) Register the driver  in Java using JDBC DriverManager      
            Class.forName("com.mysql.cj.jdbc.Driver");   
             
               System.out.println ("Connecting Database...... ");  
                Connection con=null;    
                  try {         //2) Open a connection to the database using JDBC  driverManager     
                      con = DriverManager.getConnection(url,username ,password);            
                       }catch (SQLException se ){       /* SQL Exception is caught here */           return ;}         
                   catch(Exception e){         // catching exception     if there's any error   it will go to this block of code  and print the stack trace      System.out.println ("Could not connect database server... " +e);    }                  try {            /* execute query here */              Statement stmt= con .createStatement();            
                            ResultSet rs =stmt.executeQuery("SELECT * FROM your_table");          //3) Executing a Query       while(rs.next())         System.out.println (rs.getString('your column name'));  }      finally {   try{connections are always closed here by the "finally" block}catch(SQLException se){System.out.println("Closing connection."); con .close();}}          //4) end of main method
            /* End JDBC code */        catch ( SQLException e )  {e.printStackTrace(); }         System.exit(0);   }}