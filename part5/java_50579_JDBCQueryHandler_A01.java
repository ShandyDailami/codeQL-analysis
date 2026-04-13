import java.sql.*; // Import necessary classes 
  
public class java_50579_JDBCQueryHandler_A01 {    
    public static void main(String[] args) {         
        String url = "jdbc:oracle:thin:@localhost:1521:xe";          
              
        try (Connection conn =  DriverManager.getConnection(url, "username", "password");  // Connect to database     
             Statement stmt  =conn.createStatement())   ) {             
            String sql ="select * from Employees where Salary > ? and Department=?";          
                    
                ResultSet rs =  stmt .executeQuery(sql);        
               while (rs.next()){                         // Iterate through each row      
                    int salary  =   rs.getInt("Salary");       
                      String dept =    rs.getString ("Department") ; 
                 System.out.println("\n Employee details: ");        
                  System.out.print(" Salary : " + salary);           // Print the values from each row      
                   System.out.print(", Department :"  + dept );     #   and department name    print it out to console 
                }                     stmt .close();      rs.close() ; conn.close ( ) ;}          catch(SQLException ex){           // Handle any SQL exception      
                                              System.out.println ("Error in establishing the connection or executing query: " +ex);         };   }}`;