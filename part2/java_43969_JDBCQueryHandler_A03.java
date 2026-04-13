import java.sql.*; // Import necessary classes from Java library (Java's standard database API)  
public class java_43969_JDBCQueryHandler_A03 {    
    public static void main(String[] args){        
        String url = "jdbc:mysql://localhost/test";// Provide your own MySQL server details here. 
        String username="root", password="password1234567890_DBA!"; //Replace with the actual values if needed           
           try{            
               Connection conn = DriverManager.getConnection(url,username ,password);             
                   System.out.println("Connected to MySQL");      
                    String queryString="SELECT * FROM Employees WHERE id > " + args[0]; //Assuming the input is provided as an argument in command line like 'java JDBCQueryHandler 123'    
                      PreparedStatement pstmt = conn.prepareStatement(queryString);            
                    ResultSet rs=pstmt.executeQuery();           
                     while (rs.next()) {              System.out.println("Id: " + rs.getString("id"));         }              
                   // Don't forget to close resources like connections, statements and resultsets at the end of each operation            
                      conn.close();  pstmt.close();   rs.close();         
                           System.out.println("Disconnected from MySQL");       }}            catch(SQLException e){        } // Handling SQLExceptions     finally{         try { if (conn != null) conn.close();}           catch (SQLException ex) {}      }  });