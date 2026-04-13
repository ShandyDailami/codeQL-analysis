import java.sql.*;  // Import Java Database Connectivity (JDBC) API to access MySQL database  
    
public class java_49248_JDBCQueryHandler_A07 {   
       public static void main(String[] args){       
           String url = "jdbc:mysql://localhost/testdb";     
         final String userName="username";                  //replace username with your actual mysql server details 
          final String password=  "password1234567890qwertyuiopasdfghjkzxcvbnmlkjhgfdstvrfyuistwxutsrqponmlkhbijuk";   //replace Password with your actual mysql server details 
    	   
           try {                 
                Connection conn = DriverManager.getConnection(url, userName , password);             
                    System.out.println("Successfully Connected!"+conn );      }       catch (SQLException e)         {          e.printStackTrace();    }}            //end of main method}