import java.sql.*;   //Importing required libraries 
public class java_45476_SessionManager_A08 {    //Creates the main Class name as "Session Manager"    
        private static Connection conn = null;       //Declaring a variable to hold connection objects and initializing it with NULL at first     
         public ResultSet executeQuery(String query) throws SQLException   /*Create function for executing queries */ { 
             if (conn == null || !conn.isValid())   
                throw new SQLNonTransientException("Connection is not valid");     //Throw exception in case of NULL connection or invalid Connection        
            Statement stmt = conn.createStatement();      /*Create a statement for executing queries */ 
             ResultSet rs=stmt.executeQuery(query);        /**Execute the query and return result set*/   
                 if (rs != null)   //If there are results, print them out     console.log("Found " + usersCount()+" Users");       /*Print number of found records */  else      Console.WriteLine ("No Results Found ");              } catch(SQLException se) {Console . Write Line("\n In Exception Occurred: $se \t\n") ;}   
             return rs;   //Return the result set     console("Closing database connection");       /*close db connections */  try{conn.close();      System.gc();}catch(Exception se){Console . Write Line("\ne Exception Occurred: $se \t\n") ;}
        }    static void Main (String[] args) {            //Create a main method     SessionManager sm = new Session Manager;         try{sm.executeQuery("SELECT * FROM Users"); Console.WriteLine ("Executing Query 1...");      /*Run the query*/       String strSQL  = "INSERT INTO USERS(ID , NAME, PASSWORD ) VALUES (?, ?,?)";     PreparedStatement pstmt=conn .prepareStatement   (strSQL );          //Set up statement for insert into users table and update SQL details here: 
pstmt.setInt    (1,20);      /*Here we set the parameters to our preparedstatement*/         String pass ="password";     pstmt.setString(2,"new User");       /**/        }catch   //Catch block for exceptions            catch {} Console . Write Line ("Closing database connection..." ); conn.close ();}}