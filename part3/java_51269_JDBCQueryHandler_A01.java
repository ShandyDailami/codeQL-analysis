import java.sql.*;   // Importing necessary Java libraries/packages (SQL related)    
public class java_51269_JDBCQueryHandler_A01 {  // Defining a Class with main method for program execution     
    public static void connectToDatabase(String url, String userName, String password){      
        try{          
            Connection connection = DriverManager.getConnection(url ,userName,password);     /*Establish the database connectivity*/        
             System.out.println("Connected to Database");      //Confirmation message         
              }  catch (SQLException e) {                     //Catching and handling exceptions                         
            e.printStackTrace();                            //Print exception details if any                             
        }}       void main(String args[]){                  /*Main method calling other methods*/        
             connectToDatabase("jdbc:mysql://localhost/test","root", "password");     }     
}