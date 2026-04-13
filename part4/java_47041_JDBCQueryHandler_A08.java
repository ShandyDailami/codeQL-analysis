import java.sql.*;   // Importing required classes from Java's Standard Library    
class java_47041_JDBCQueryHandler_A08 {    // Declaring a main Class in JAVA Programming Language     
public static void main(String[] args)  throws SQLException{         
//creates the connection and print out its properties        
Connection con = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username","password"); //Replace with your own username, password  
System.out.println("\n Connection Properties : ");           System.out.println(con);          return; }  catch (ClassNotFoundException e) {    throw new SQLException(e);}}`