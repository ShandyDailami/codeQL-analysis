import java.sql.*;   // for SQL related classes such as Connection etc...   
public class java_42511_JDBCQueryHandler_A01 {     
     public static void main(String[] args)  throws Exception{       
         String url = "jdbc:mysql://localhost/mydatabase";      
         String username="usernamehere";         
         String password="passwordhere";   // for mysql database. Remove the '//' and replace with your actual db name     
          
         Connection con;  /* this is reference to our connection object */   
            
        System.out.println("Connecting To Database...");      
          try {           
              Class.forName("com.mysql.cj.jdbc.Driver"); //load the driver class  
              
                con= DriverManager.getConnection(url, username , password );  /*here we are connecting to database */   
             System.out.println("Connected Successfully...");        }       catch (Exception e) {     println ("Cannot get connection");      return; }}                  //end of main method