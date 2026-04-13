import java.sql.*; // Import the necessary classes from SQL package  
public class java_47176_JDBCQueryHandler_A07 {    
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";     
    private static final String username="root"; 
    private static final String password=  "password12345!"; //Assuming the database user has a default SQL root (username) and hardcoded pass    
      
   public Connection establishConnection(){       
           System.out.println("Connecting to DB...");         
         try{           
             Class.forName("com.mysql.jdbc.Driver"); //Load the driver from MySQL Database     
              return DriverManager.getConnection(url, username , password );   }    catch (ClassNotFoundException | SQLException e){        System.out.println ("Error in connection: " +e);          return null;     }}       public void mainAuthFailureTest() {         Connection con = establishConnection();
           if(con !=null) 
               System.out.println("Successfully connected!");   else    //if not successful, do something...        }            catch (SQLException e){          e.printStackTrace(); }} });`}}