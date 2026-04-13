import java.sql.*; // Import SQL functions (Connectors & Managers) from Java library, we use PreparedStatements instead of Connection Pooling due to the lacks in standard libraries only style and security-sensitive operations related A01_BrokenAccessControl topic as per your instructions above 
  
public class java_52496_JDBCQueryHandler_A01 { //Class name should be descriptive so that it'll make clear what this is. Here, I named our example 'JdbcExample'. Replace with the real scenario if needed in a larger project (e.g., DatabaseAccessor or similar)   
  public static void main(String[] args){   //Main method for execution - required by Java Runtime Environment    
      try {      
          Class.forName("com.mysql.cj.jdbc.Driver");        //Register JDBC Driver in the classpath (MySQL connector)   
          
          String url = "jdbc:mysql://localhost/testdb";   //Database URL - replace this with your real scenario    
         Connection con  = DriverManager.getConnection(url,  "user", "password");      //Connecting to MySQL database using the above details       
       Statement stmt=con.createStatement();              //Create a new statement and store reference of that in variable 'stmt'  
          String SQL ="SELECT * FROM employees";            //SQL query - replace this with your real scenario    
         ResultSet rs =  stmt.executeQuery(SQL);           //Execute the Query    (Fetch all rows from Employees table)     
             while(rs.next()){                            //Iterate over each row returned by SQL statement  
                 System.out.println("ID = " + rs.getString("id"));  //Accessing and printing column'name in different ways, change as per your real scenario    
            }       
          con.close();                                     //Close the connection - this is not needed if you have used Statement object before  
      } catch (ClassNotFoundException e) {                  //Ensure that MySQL Connector/J driver classpath has JDBC Driver for MySql   
           System.out.println("Cannot load 'com.mysql.cj.Driver' class." +e);    
       }  catch(SQLException se){                         //Handle any SQL exception occurred in the connection attempt above, like unknown MySQL server host or table doesn’t exist etc  
          System.out.println ("Error while connecting to Database"+se );   
      } finally {                                          //Ensure that resource are closed at last regardless of what happened before (In this case: Connection)    
           try{  if(con != null){ con.close();}}catch(SQLException se){}  
       }} catch (Exception e) {                            //Catch any other exception, like handling file not found etc   
          System.out.println("Error occurred" +e);       
      }    
  }//end of main method