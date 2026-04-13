import java.sql.*;   // Importing the required classes from 'package'   
class java_43262_JDBCQueryHandler_A01 {    
public static void main(String[] args) throws SQLException{     
        String url = "jdbc:mysql://localhost/db";      
        String username="username";  (make sure to replace with your actual mysql db name and user, password if any.)   //your MySQL database Username   
        String password=  "";         ///Your MySql Database Password     
     Connection connection = null;         
           try{           
             connection =  DriverManager.getConnection(url , username  ,password);       System.out.println("Connected to the db");                  }catch (SQLException e){   //Catching any SQL Exceptions   
                throw new IllegalArgumentException("Cannot connect with DB",e );              }finally{     if((connection != null) && connection.isClosed() == false )       {  try {        connection.close();      }}         
         else                                                System.out.println( "Connection was closed");}};   //closing the db Connection    If it's already opened or not available (it means that database is down) then, do nothing           }; }});              while(!condition){  ///Your condition to check if connection should still be open in real scenario });