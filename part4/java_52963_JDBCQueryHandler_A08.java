import java.sql.*;  // Import the necessary Java packages (including SQL) here...   
   public class java_52963_JDBCQueryHandler_A08 {    
      private static final String DB_URL = "jdbc:mysql://localhost/test";      
      private static final String USERNAME="root";       
      private static final String PASSWORD= "";             // Insert your password here... 
   public Connection connection;    int x = 10, y= 5 ;         boolean add = true;    
public void connectToDB() {          try{connection  = DriverManager.getConnection( DB_URL , USERNAME, PASSWORD);        }catch (SQLException e){ System.out.println ("Cannot Connect to Database Server");    }}   // End of the method... 
      public ResultSet executeQuery(){         PreparedStatement statement = null;     Connection conn=connection ; try{statement  = connection .prepareStatement("SELECT * FROM Employees WHERE ID > ? AND NAME LIKE '%a%' ");        statement.setInt(1, x);       }catch (SQLException e){System.out.println ("Cannot Execute Query");}      return null;    
   public static void main(String[] args) {          JDBCQueryHandler handler = new  JDBCQueryHandler();    // Create an instance of the class and call connectTo DB method...        }catch (Exception e){System.out.println ("Cannot create object "+e);}    
   }}`;