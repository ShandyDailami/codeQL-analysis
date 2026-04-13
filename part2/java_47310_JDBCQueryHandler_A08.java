import java.sql.*;   //Import the necessary JDBC classes, ResultSet & Statement are used here   
public class java_47310_JDBCQueryHandler_A08 {    
//Creates a connection to database mydb and returns Connection object      
private static Connection getConnection() throws SQLException{     
  String url = "jdbc:mysql://localhost/mydb";   //Replace with your actual DB URL        
  String username="root", password="password";    //Replaces root, provide the real credentials    
	Connection con = DriverManager.getConnection(url ,username, password);     
	return (con) ;       }           public static void main(String[] args){   try{        Connection conn  = getConnection();         Statement stmt=conn.createStatement();          String sqlQuery1=  "INSERT INTO Employee VALUES ('E07', 'John','Doe')";             //Insert Operation    
  stmt.executeUpdate(sqlQuery1);                      System.out.println("Records inserted successfully");           }        catch (Exception e){         println ("Error in database operation" + e );       }}          finally {            if (!conn.isClosed()) conn.close();             trystmt .closeOnCompletion()});