import java.sql.*;   //Importing necessary classes for JDBC operations 
public class java_52910_JDBCQueryHandler_A03 {    
    public static void main(String[] args) {      //Main method that runs the program       
       String url = "jdbc:mysql://localhost/mydatabase";//Connection URL to MySQL database        
       String username="username_here";  //Username for SQL Server instance (change accordingly if you're using a different DBMS, or provide null)   
      String password=  "password_here";   //Password of the user account used in connecting databases. Do not share this info publicly because it can be misused to attack your database.(Provide Null as well).  This is done for security sensitive operations related A03 Injection      
     try {        //Try block starts here         
         Class.forName("com.mysql.cj.jdbc.Driver");   //Loading MySQL JDBC driver           
           System.out.println("Connecting to database...");     
             Connection con= DriverManager.getConnection(url,username ,password );     //Getting the connection   
          Statement stmt =con.createStatement();       
         String sql  = "select * from users";   //SQL query          
            ResultSet rs; 
               System.out.println("Query is :" +sql);      
              rs=stmt.executeQuery(sql );    
                while (rs.next())      //Traversing the result set   
                  {          //Print values of each column:   for example, "id",  can be replaced with your actual field names and table structure fields                 System.out.println("Id is :" + rs.getString(1));           }      
        con.close();     //Closing the connection         printf("\n");          return;    }} catch (Exception e) {      console.log('Error: '+e);  };}}};catch block will handle any exception and stop program execution when encountered in a try-block