import java.sql.*;   // Import the necessary classes for Java DB connections, statements etc   
public class java_53843_JDBCQueryHandler_A07 {    
       static final String url = "jdbc:mysql://localhost/test";     
       static final String username="username";             
       static final String password="password";              
        public void main(String[] args)  // The entry point of the program.          
            throws SQLException          // Exceptions thrown by JDBC API are handled in this block        
    {             System.out.println("Connecting to database...");     
       Connection con=DriverManager.getConnection (url,username,password) ;    
        Statement stmt = null;  ResultSet rs  =null;   // Declare a statement and result set objects         
                try           {             System.out.println("Connected Successfully...");     
                       String query="select * from Employee";            Stmt =  con .createStatement();    stmt =con.createStatement() ;  rs  =stmt.executeQuery(query) :                 while (rs !=  null ) {              System.out.println("Employees Details: " +  
               "\nID \t Name \t Department\t Salary");                // While loop to iterate through the data fetched from DB         }          finally           try             {  con .close();            stmt?.close() ;              rs ?.close():null;}catch (Exception e)    
               {}       System.out.println("Closing connections and statements...");      return;}}};// Program ends here   // Main method is the entry point of any Java program          }  catch(SQLException se){se .printStackTrace()} finally {    try             { con?.close(); stmt ?.close () ; rs? . close (): null;}catch
               ( Exception e ){e. println("Error Occured while closing connections" +   "and statements");}};  // Catch block to handle exceptions           }     }}//End of Main method      void main(String args[]) { try          {} catch         () throw SQLException              in methods, all the code is inside a finally clause. The program ends when this happens or an exception occurs (SQLExceptions).