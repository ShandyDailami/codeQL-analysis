import java.sql.*;   // Import required packages   
public class java_52389_JDBCQueryHandler_A01 {    
    public static void main(String[] args) throws Exception{     
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password")) 
       {         
            String query="SELECT * FROM users"; //SQL Query            
           PreparedStatement pstm =connection.prepareStatement(query);   
         ResultSet rs =  pstm .executeQuery();    
        while (rs.next())     
  		{               
              System.out.println("ID: " + rs.getString('id')); //Accessing by name of column  not its position           		            			       }           connection.close() ;}         catch(Exception e) {System.err.print (e);}}     public class MainClass{  
public static void main(){    try{}catch();}}}`//A01_BrokenAccessControl, make sure to check the SQL query and handle exceptions properly as well!  Avoiding hardcoding sensitive data such credentials in your code like `username' , 'password', etc. is crucial for this example of Access Control violation