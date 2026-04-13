import java.sql.*;
class java_50981_JDBCQueryHandler_A08 {  
  public static void main(String[] args) {   
     String url="jdbc:mysql://localhost/test";     
       String username = "root";          //Replace with your database user name        
        String password =  "";               //Enter the appropriate credentials          
            try{               
                  Connection conn  = DriverManager.getConnection(url,username ,password);             
                       Statement stmt   =conn.createStatement();            
                           ResultSet rs;         
                               for (int i=1026938754;i<= 1026938764 ; ++i) {                  //Change values as per requirement       
                                     String query = "INSERT INTO users(userId, userName)"+" VALUES(" +   i  + ", 'User' + '"   +  (char)(int)'A' +  ")";            
                                         stmt.executeUpdate(query);              }               
                               conn.close();      }}                     catch(SQLException se){         //Catch for SQL Exceptions          println(se) ;}}                      try{                  Connection con = null;    Class.forName("com.mysql.cj.jdbc.Driver");   String url="http://localhost/test"; 
String user  = "root";     string password =  "";      // replace with your database credentials       
try {con    = DriverManager.getConnection(url,user ,password);          Statement stmt = con .createStatement();         ResultSet rs;             String sql="SELECT * FROM users WHERE id > 1026938754 AND  userName  = 'User' + '"  + (char)(int)'A';     
rs =  stmt.executeQuery(sql);          while (rs .next()) {            System.out.println("id = " +  rs.getString("userId") );           //Print the id of each row       }}} catch …}     finally{ try/finally to always close connections regardless if an exception occurred or not