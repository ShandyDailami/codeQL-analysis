import java.sql.*;   // Importing necessary classes from JDBC package (ResultSet, Statement etc.)   
                  
public class java_45495_JDBCQueryHandler_A03 {    
  public static void main(String[] args) throws SQLException{        
      String url = "jdbc:mysql://localhost/test";      
          // MySQL connection details. Replace with your actual database info       
          
      String username="root";           
          // Root user for the above-mentioned db (replace it as per usual)  
 
     String password="password@1234567890!";   
         // Password set in MySQL server. You should replace this with your actual database's access details      
      Connection con = DriverManager.getConnection(url,username , password);         
        /*Getting connection object using the above credentials*/  
          
     Statement stmt=con.createStatement();    //Creating a statement  for executing SQL queries on DB        
            int x;      
             String query = "SELECT COUNT(*) FROM Users";     
                         /**** Creates an Sql Query to select all users from the database ****/  
                ResultSet rs=stmt.executeQuery(query);     //Executes above created sql statement and stores result in a set  object   
            if (rs != null) {                             /*If no user found then return false else true */        while (( x = rs.next()) > 0){      }                  System.out.println("No users");                con.close();          //Closes the connection  
                 }}catch(SQLException sx){                   /**Handles SQL Exception if any occurs during execution of this block*/        
        try {con.close();} catch (SQLException e) {}     /*Ensures even in case, it will close successfully */    }  // Ending the main method   }) ;       }} );}};            }));      };             stmt . execute update delete from ...... and so on....