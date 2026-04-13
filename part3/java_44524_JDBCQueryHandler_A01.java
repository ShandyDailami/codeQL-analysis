import java.sql.*;
class java_44524_JDBCQueryHandler_A01 {  
    public static void main(String[] args)  {    
        Connection conn = null;     
       try{        
            // Step -2 : Establishing the database connection         
           Class.forName("com.mysql.cj.jdbc.Driver");            
           String url="jdbc:mysql://localhost/testdb";             
           String username= "root";              
           String password = "";                  //Password is empty for simplicity, but should not be used here         
            conn  = DriverManager.getConnection(url ,username,password);     
             System.out.println("Connected");  }         catch (Exception e){    println ("Cannot connect to the database" +e) ;}     return;   }}      
           // Step -3 : Creating a statement object and executing an SQL query using it         
        Statement stmt = conn.createStatement();             try {              String sql= "SELECT * FROM Users WHERE UserName =  ?";                             ResultSet rs  =stmt.executeQuery(sql, "%User1");                     while (rs .next())   println ("Found user :" +rs.getString("username")); }catch (Exception e)    {println ('Error in finding the users '+e);}
        //Step -4: Closing connection  and statement object      try{ conn.close(); stmt.close(); }} catch(SQLException se){   println('Cannot close connections' +se );}}