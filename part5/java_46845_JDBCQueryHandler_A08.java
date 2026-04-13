import java.sql.*;   // Import Statement, PreparedStatement & ResultSet classes   
public class java_46845_JDBCQueryHandler_A08 {    
      
      private static final String url = "jdbc:mysql://localhost/test";//database connection parameters here        
      public Connection conn;       
      protected Statement stmt=null;   // Declare a statement object         
  ResultSet rs ;           
   
public void connectDB() {    
           try{      
                 System.out.println("Connecting to database ...");            
                  this.conn = DriverManager.getConnection(url,"root","password");//replace "username" and password with your actual username, you can put null for root as it's a default one in mysql     // replace 'localhost/test', 'user','passwd'. 
                 System.out.println("Database connected successfully.");       }      catch (SQLException e){       
           System.out.println(e);            };    });  
}               public void executeQuery() {          try{              this.stmt = conn.createStatement();         // create a statement object                rs= stmt .executeQuery("select * from employee");             while (rs.next())                 String name =  rs.getString(1);                  System.out.println("\n Name: " +name );           }
catch (SQLException e){System.out.println ("Error in executing query"+e) };   });  public static void main(String[] args) {          VanillaJavaJdbcQueryHandler db = new VanillaJavaJdbcQueryHandler();      //create an object for our class        db .connectDB ();        
db .executeQuery () ; }           }}