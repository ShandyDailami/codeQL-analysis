import java.sql.*;   // Importing required classes from Java's Standard Library (JDBC)   
class java_46469_JDBCQueryHandler_A08 {    
public static void main(String[] args){         
//Step1: Establish a connection to the database     
try{           
Class.forName("com.mysql.cj.jdbc.Driver");  // Loading MySQL driver into Java Virtual Machine (JVM)      
Connection con= DriverManager.getConnection(    "url","username",   "password") ;            
System.out.println ("Connected to the database ");           
//Step2: Execute SQL queries     
PreparedStatement pstmt;              // Declare Prepared Statement object for executing prepared statements on a database using JDBC      
String selectQuery="SELECT * FROM Employee";     // Define your query here       
pstmt = con.prepareStatement(selectQuery);  // Create the statement and store into variable "pStmt".     
ResultSet rs  = pstmt.executeQuery();   // Execute Query, Return Result Set       System.out .println ("Executing select ...");         while (rs != null &&    rs.next()) {            String name =     rs.getString("name");             int age =  Integer  . parseInt(rs.getNString("age"));             
System. out . println "Records of Employee table: ");                System ..println ("Name :" + name+ ", Age:" +  age );        }            con.close();         // closing connection          }}       catch (SQLException e) {e..printStackTrace()}  finally   {}
    public void closeConnection(Connection conn){      if ((conn != null))     try{con.close(){             System . out . println ("Closed Connection")} }catch( SQLExceptio n )            {n...println ( "Error in closing connection");        }}       catch   {}
}