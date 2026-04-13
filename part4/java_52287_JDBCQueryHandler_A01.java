import java.sql.*;
  
public class java_52287_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost/testdb"; // replace with your db url and name 
    private static final String USERNAME ="root";//replace root if you are using windows machine else provide username. Also ensure that MySQL server is running on the given database instance in this location(URL).  
     public static void main (String[] args) {        //main method, where execution of java starts here 
          Connection conn=null;                 //declaration and initialization for connection object   
           try{                                 
            Class.forName("com.mysql.cj.jdbc.Driver");   /*Loading the driver class */                 
             System.out.println ("Connecting to database... ");    
               conn = DriverManager.getConnection (URL,USERNAME,"");      //establishing connection with mysql server  and password blank if not specified else provide your MySQL root Password   
            Statement stmt=conn.createStatement();                    /*Creates a new statement object */  
             ResultSet rs;                                            //declaration of resultset for handling data fetched from database    
              String sql ="SELECT username, password FROM Users WHERE role_id = 1";  ///replace the query with your actual one       
               System.out.println ("Running select statement...");   /*print statements to console while running a SQL command */    //displaying message on screen and then run selected queries     rs = stmt .executeQuery (sql );                if there is any exception or error print it out                      try {                                                                         
                    while(rs.next()){                              ///while loop will iterate over each row in result set  
                     String username=rs.getString("username");    //accessing data from column name  as per table schema and assign to a variable      
                         System.out.println ("Username: " +         /*print statement for user information */         
                                                 username);       
                      }                                            ///end of while loop  
                  } catch (SQLException e) {                    //catch block when there is an error in the execution      print it out  end try-Catch    finally{                                                                            if(conn != null){                             /*closes connection*/                     conn.close();                                                       }}                        });}}}}});