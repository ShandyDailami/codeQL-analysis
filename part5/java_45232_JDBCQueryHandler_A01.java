import java.sql.*;   // Import necessary Java classes for JDBC functionality   
class java_45232_JDBCQueryHandler_A01 {    
 public static void main (String[] args) {     
try{        
// Step1: Establish the connection to MySQL database         
Class.forName("com.mysql.cj.jdbc.Driver");   //load mysql driver class for connection          
Connection con = DriverManager.getConnection ("dburl", "username","password") ;  //Replace dbUrl, username and password with your DB credentials     
        
//Step2: Prepare a SQL query         
String selectQuery="SELECT id FROM Employee WHERE name LIKE '%name%'";  
             //Use appropriate values for 'id', placeholder.       
    } catch (Exception e){      
  System.out.println ("Error in establishing database connection");     
}        
//Step3: Execute the Query         
try{    
PreparedStatement pstmt=con.prepareStatement(selectQuery);   // Prepare statement for execution          
ResultSet rs =pstmt.executeQuery();    //Executing a query           
             } catch (SQLException e){      System.out.println ("Error in executing SQL");     return;  };        
          try { if(!rs.isBeforeFirst()) throw new Exception("No Result Found!");   while(rs.next())}catch(Exception ex)       //Handle the exception             }                catch (SQLException | Exception e){e.printStackTrace();}    }}