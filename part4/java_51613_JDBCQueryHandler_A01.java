import java.sql.*;   // Import necessary Java packages for JDBC (Java Database Connectivity)  and ResultSet   
class java_51613_JDBCQueryHandler_A01 {     // Define a new class named "A01_BrokenAccessControl" to prevent the naming collision with other classes in your program, e.g., Main  
public static void main(String[] args){       /* The following code demonstrates using JDBC for security-sensitive operations */ 
    String url = null;     // Define a variable named 'url' of type string to hold database URL     
    Connection con=null ;// Declare the connection object.  
    Statement stmt=null;             /* A statement is an instance representing any SQL command such as SELECT, INSERT etc */ 
                                 
try {     // Begin try block       
url ="jdbc:mysql://localhost/test";       // Set URL to connect database (replace with your actual db)    JDBC Driver name and DB url should be provided.   E.g., mysql-connector-java.jar  jdbc:mysql://username@password@hostname_or_IPaddress/dbName    
con =DriverManager.getConnection(url,"root",""); // Get connection to database from JDBC    Driver Manager is used for loading the drivers and getting connections   Root account has username as root, password not specified in db url by default 
stmt= con.createStatement();      /* A statement object */      
String sql;     /// Set a variable named 'sql' of type string to hold SQL query (e.g., select * from User where name = ..)    //Here user input should be handled properly for security reasons   e,g: String username= new Scanner(System.in).next(); 
ResultSet rs;       /* A Result Set is a container object that stores the results returned by database queries */      try {     /// Begin Try block        stmt .executeUpdate("DROP TABLE Users");    // drop table before inserting data again   if there're any issues in dropping, e.g., no such users or other tables exist 
stmt = con.createStatement();               /* Create a statement object */      sql="select * from User where name like '%"+username+"%'"; // select all records whose username contains entered value    rs =  stmt .executeQuery(sql);     /// Execute the query and obtain ResultSet   while (rs.next()) {      
System.out.println("Name: " + rs.getString('name') );  /* Print out Name in console */         }/// Close connections      con.close();stmt.close();} catch(SQLException se){se.printStackTrace();    //Catch SQL exception        try{con=DriverManager   .getConnection("jdbc:mysql://localhost/test","root", ""); 
if (null == con) {       /// If connection is not established, e.g., due to invalid url or username and password      throw new Exception("Cannot open database");}    // Re-establish the Connection if we lost it previously   }catch(Exception ex){ex.printStackTrace();}}