import java.sql.*; // Import the necessary classes from JDBC package 
  
public class java_52375_JDBCQueryHandler_A01 {
    public static void main (String[] args){
        String url = "jdbcUrl";     // Your database URL goes here e.g., jdbc:mysql://localhost/dbname;user=root;password=yourPassword      
         try{ 
            Connection con =  DriverManager.getConnection(url);   //Establishing a connection with the DB using JDBC API     
             String sql = "SELECT * FROM Users";    //Your SQL query goes here e.g., SELECT UserID, Username from Users    
              Statement stmt = con.createStatement(); 
               ResultSet rs  = stmt.executeQuery(sql);   //Executing the Query on DB      
         while (rs.next()){    //Iterating over each record     
                System.out.println("User ID: " + rs.getString('userID'));     // Access only when 'users' table has userId field  e.g., SELECT UserName from Users where Username=?;  
               }       con.close();    stmt.close();      rs . close ();         System.out.println("Database connection closed.");             }}           catch(SQLException se){se.printStackTrace();}          //Catching Exception and printing the Stack Trace                  finally {System.out.println ("Closing database connection"); } 
   };       
};