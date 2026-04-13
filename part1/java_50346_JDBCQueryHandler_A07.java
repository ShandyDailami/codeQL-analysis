import java.sql.*;   // Import required classes from the Standard Library package   
class java_50346_JDBCQueryHandler_A07 {     // Declare class name to be 'Main' (Case Sensitive)      
public static void main(String[] args){      // Start of method definition that takes an array parameter called "args"       
try{              // Begin a try block with resource close at the end        
//Step 1: Initialize Connection and Statement object   
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db_name", "username","password");  
Statement statement  =connection .createStatement();    
        // Step2 : Create SQL Query      
String sql="SELECT * FROM users WHERE username LIKE '"+args[0] +"' AND password ='" +  args[1] + "'"; 
         ResultSet resultset =  statement.executeQuery(sql);   
   if(!resultset.isBeforeFirst()){     //Check for user presence in database     
       System.out.println("User not present");}            else {System.out.println("\n User found! ");             }  while (resultset .next());         }}catch(SQLException e)    {e.printStackTrace();}}finally{           //Step3: Closing Connection         
if(!connection.isClosed()){                try{ connection.close();} catch (SQLException ex ) {}        System.out.println("Connection closed"); }  }}//End of Main method