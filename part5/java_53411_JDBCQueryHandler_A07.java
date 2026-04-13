import java.sql.*;
public class java_53411_JDBCQueryHandler_A07 {
    //Database credentials
     private static final String DB_URL = "jdbc:mysql://localhost/test";  
     private static final String USERNAME="root";                  
     private static final String PASSWORD="@Sqlserver2017$";      
     
     public java_53411_JDBCQueryHandler_A07() {  //constructor is created to ensure that the JDBCCONNECTION object will be initialized before it uses.   
         try{  
             Class.forName("com.mysql.cj.jdbc.Driver");//Load MySQL Driver (MySQL specific)          
         }catch(Exception e){       // Catch exception if any, so that we don't break the server at runtime due to an error in our code   
          System.out.println("Error loading MySql driver!");     
            e.printStackTrace();  
        } 
     }//End of Constructor   
      
     public boolean checkLoginCredentials(String username, String password){ //method for checking login credentials with the database server
         try{                          
             Connection con=DriverManager.getConnection(DB_URL ,USERNAME ,PASSWORD);            
             Statement stmt =con.createStatement();         
               ResultSet rs =  stmt.executeQuery("SELECT * FROM USERS WHERE username LIKE '"+username+"' AND password  LIKE'" +password+"';"); //replace with actual SQL query if required      
             while(rs.next()){  
                  System.out.println("\n Found User: "+ rs.getString('user'));   
                 }         
         return true;    
        }catch (Exception e) {     
           System.out.println("Error in connecting with database"); //Print stack trace if exception occurs      
            e.printStackTrace();  
             return false; 
              }//End of try-catch   
}         
 public static void main(String[] args){     ///main method for testing our program     
        VanillaJDBCQueryHandler v = new VanillaJDBCQueryHandler (); //instantiate a object      
         if(!v.checkLoginCredentials("Admin","admin")) {    //call the checklogincredentials function with valid credentials     }          else{  System.out.println("\n You have entered wrong username or password");}           });   }}//end of main method