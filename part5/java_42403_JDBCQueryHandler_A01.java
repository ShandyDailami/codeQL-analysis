import java.sql.*;   // import the necessary classes 
// Driver class java_42403_JDBCQueryHandler_A01 by JVM at runtime to connect with database server such as MySQL Server or Oracle Database and creates a connection between program & DB   
public class VanillaJDBCQueryHandler {    
      static final String url="jdbc:mysql://localhost/test";   //replace URL, username, password etc. according your setup 
       public static Connection getConnection() throws SQLException{          
         return DriverManager.getConnection(url,"username","password");    }            
        private Connection conn;    
      void openConnection(){            try {conn=VanillaJDBCQueryHandler .getConnection();}catch (SQLException e){e.printStackTrace();}}  //open the connection to database  
       public PreparedStatement createPrepareStatements(String query) throws SQLException{return conn.prepareStatement(query); }        void executeUpdate(String update)throws SQLException {conn.createStatement().executeUpdate(update)}    String readQueryResult (String select )  throws Exception     {        
       Statement stmt=null;          try            {stmt = conn.createStatement();}catch (SQLException e){e.printStackTrace()};           //statement to execute the query on database server                  return rs.getString("name");}}             public static void main(String[] args)  throws Exception{        VanillaJDBCQueryHandler handler=new   
          Voila! JDBCImp();handler .openConnection (); String insert = "INSERT INTO Employees" +"(id, name)"+   ("1,'John')";            //Create a new row in the 'employee' table and set id to 2.        Your code should not contain any SQL injections as it doesn’t interact with user input at all!         
           handler .executeUpdate(insert);         String select ="SELECT * FROM Employees WHERE name='"+ "John";';                //select a row in the table where 'name' is John.        Your code should not contain any SQL injections as it doesn’t interact with user input at all!         
           ResultSet rs  = handler .readQueryResult( select);               System.out.println (rs) ;}}             void closeConnection(){conn=null}    }   //close the connection to database     If you are not using 'AutoCloseable' interface, then ensure it is properly managed as per your application requirement