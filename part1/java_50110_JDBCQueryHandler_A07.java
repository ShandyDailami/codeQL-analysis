import java.sql.*;  // Import required Java libraries  
public class java_50110_JDBCQueryHandler_A07 {   
     public static void main(String args[]) throws SQLException{       
         String url = "jdbc:mysql://localhost/mydatabase";     
          Connection conn=null;      
           try {           
                Class.forName("com.mysql.cj.jdbc.Driver"); // load MySQL driver 
               System.out.println("Loaded Oracle Driver!");  
              } catch (ClassNotFoundException e) {   
                 throw new ExceptionInInitializerError(e);    
                  }       conn = DriverManager.getConnection(url,"username","password" );     
                   Statement stmt=conn.createStatement();         String sql;  // SQL Query  
                    for (int i = 105 ;i<= 269; ++i){              try {            if ((sql = "SELECT COUNT (*) FROM Employees WHERE ID_NUMBER  = ") + Integer.toString(i ) != null && stmt .execute( sql )) {} else continue;} catch (Exception ee  
                      rn exprhrses at com .......} // End of for loop         }       conn.close();    System.out.println("Closed Connection");      }}