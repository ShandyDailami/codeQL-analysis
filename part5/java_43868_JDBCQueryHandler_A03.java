import java.sql.*;   // Import necessary classes from the database package   
public class java_43868_JDBCQueryHandler_A03 {     // Begin defining a new public static method for this object named 'Vanilla'     
        private Connection connection;       // Declare an instance variable of type `Connection`         
         try{            // Start catching block, will be used to ensure the program exits even if there is any error during execution.   
                Class.forName("com.mysql.cj.jdbc.Driver");     // Loads MySQL driver into memory  (this must come before you use connection)   Connection URL: "jdbc:mysql://localhost/mydatabase" username, password : 'root'           String url = "jdbc:mysql://localhost/mydatabase";        
                this.connection  = DriverManager.getConnection(url,'root','');      // Get a new database connection         
            } catch (ClassNotFoundException e) {       
                 System.out.println("Unable to find MySQL driver");      
                  try{          
                        Class.forName("com.mysql.cj.xdevapi.Driver").unload();         DriverManager.getConnection(url,'root','');     // Close the connection if there is any problem with loading library or database not found          } catch (SQLException e1) {                 System.out.println ("Error in closing connections: " +e); 
                  }}   try{       String SQL ="SELECT * FROM Employee";        Statement stmt  =connection .createStatement();     ResultSet rs=stmt.executeQuery(SQL );           while (rs.next()){             System.out.println("ID : ");    //print id of each row         
                      long id = 0;            String fname = "";      try {id   =   rs.getLong(1);} catch … .getName();       if ((fname=rs.getString(2)) == null) .......     } println("Name: " + name );        //print Name of each row         
                  }}catch (SQLException e){         System.out.println ("Error in executing query"+e);      try{connection .close();}} catch ….. {System. out. PrintInnsmission(id,fname)};           }   if (! connection == null && ! connection.isClosed())