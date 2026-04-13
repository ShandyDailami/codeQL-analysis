// Step1 : Add MySQL JDBC Driver library into your project dependencies if not already there, you can download it through Maven or directly in the src/main file of Eclipse by clicking on File -> Project Properties... then select Java Build Path and Libraries. Click "Add Library", browse for jdbc driver (like mysql-connector) that matches with MySQL JDBC Driver version
// Step2 : Import necessary classes from java library 
import java.sql.*; // import Statement, PreparedStatement etc., required in your code   
  
public class java_52234_JDBCQueryHandler_A03 {    
 public static void main(String[] args){        
          String url = "jdbc:mysql://localhost/test";        Connection conn=null;      try{           Class.forName("com.mysql.cj.jdbc.Driver");  //loads the driver      
                    System.out.println ("Driver loaded...");     conn =  DriverManager.getConnection(url,"root","password@1234567890") ;         printStatement (conn)    ) } catch {...}finally{ tryCloseConnnection();}} // end of main method
      ...   private static void  printStatement(final Connection conn){        PreparedStatement pstmt = null;       if(!conn.isClosed() && !Thread.currentThread().isInterrupted())    System.out.println("Connection success...");     String selectSql="select * from users where id = ?" ;   try{pstmt=  conn .prepareStatement(selectSql)  }catch (SQLException sqlEx){System.err.println ("Error in SQL : " +sqlEx );return;} // end of print statement
 ...    private static void finally {tryCloseConnnection();}      if(!conn.isClosed() && !Thread.currentThread().isInterrupted())  System.out.print("Connection success...");     pstmt .executeUpdate () ; } catch (SQLException sqlEx){System.err.println ("Error in SQL : " +sqlEx );}} // end of main method