import java.sql.*;   // Import the necessary classes from JDBC package
class java_52391_JDBCQueryHandler_A03 {   
public static void main(String[] args)    
{     
try      
{              
// Step1: Establish a Connection               
Class.forName("com.mysql.cj.jdbc.Driver");   // Load the MySQL driver          
Connection con = DriverManager.getConnection ("jdbc:mysql://localhost/mydatabase", "root","password@1234567890");  /* Create a connection */        
         
// Step2 : Execute SQL Query               
Statement stmt;   // Declare statement object          
stmt = con.createStatement();      //Create Statement Object            
String sqlQuery="SELECT * FROM users";     // Your select query           
ResultSet rs = stmt.executeQuery(sqlQuery);  /* Execute Query */             
         
// Step3: Processing the Result              
while (rs.next())   {   
System.out.println("Records are fetched successfully.");          
String id=rs.getString("id");             //Fetch String data                   
String name = rs.getString("name");       // Fetch string Data                    
int age  = rs.getInt("age");              //fetch Integer  Value                  
System.out.println(id+" " + name  +   "" +  age);         /* Print the values */             }           System.exit(0) ;            }}catch (Exception e){    Emit this code if there're any errors during DB operations like JDBC related, SQL Syntax and so on          throw new ExceptionInInitializerError("Unable to connect");   };