import java.sql.*;
public class java_44261_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws SQLException{        
        String url = "jdbc:oracle:thin:@localhost:1521:xe";       // your database URL here     
        String username = "user";   // replace with actual user name.  Replace 'password' too as per Oracle DB setup         
        String password="password";    //replace this to the real one in oracle db settings or use java keyring if running on a Linux machine    
          
       try {            
            Connection con = DriverManager.getConnection(url, username, password);             
              
         Statement stmt  =con.createStatement();         
        String sql="select user from dual";      //Your SQL Query here to select the current logged in User Name               
           ResultSet rs;  
            for (rs =stmt.executeQuery(sql)) {      
              if(rs.next()){            
                 System.out.println("UserName : " + rs.getString('user'));               //print user name  or any operation related to security sensitive operations here         }                       DriverManager, Connection and Statement are part of JDBC API        };   con.close();    stmt .close();     
            }} catch (SQLException se){se.printStackTrace();}     finally {       // make sure close all resources in a try-catch block  if necessary }});}};//end main method}}}          ;}));}))`