import java.sql.*;   // Importing this allows us use of Connection, Statement etc by JDBC API in Java program   
public class java_44701_JDBCQueryHandler_A01 {    
 public static void main(String[] args) throws SQLException{        
//Step1: Establish a connection to the database         
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root", "password");       //Here, replace with your actual MySQL server details     
System.out.println ("Connected Successfully!");    
       
//Step2 : Create a statement object   
Statement stmt = con.createStatement();  
String sql="INSERT INTO EMPLOYEE(ID,NAME,DEPARTMENT) VALUES('1','Raj', 'Sales')";       //Inserting data into the table     
stmt.executeUpdate(sql);     System.out.println("Data inserted successfully!");    }  
  public static void main (String[] args){         try { VanillaJdbcExample db = new VanillaJdbcExample();        db.main ("");}catch (Exception e) {}      }}          //Closing the connection object     con.close() ;}}}}}           This is to stop any possible resource leaks