import java.sql.*;  // import necessary Java Packages  
    
public class java_53442_JDBCQueryHandler_A07 {   
       public static void main(String args[])     
        {         
            Connection con = null;             
                try{            
                    Class.forName("com.mysql.cj.jdbc.Driver"); // Load Driver for MySQL database 
                   System.out.println("\nConnecting to Database...\n");  
                         String url="jdbc:mysql://localhost/testdb";   
                        con = DriverManager.getConnection(url,"username","password");         
                }catch (Exception e){       // Exception Handling  for JDBC related issues    
                    System.out.println("Error in establishing the connection to database!");  
                            e.printStackTrace();   
                 }     
              if(con != null) {           
                   try{               
                         PreparedStatement pstmt = con.prepareCall("SELECT USERNAME FROM EMPLOYEE WHERE AGE < ?" );          // Create a prepared statement  
                          pstmt.setInt(1,30);                  // Set the parameter value          
                           System.out.println("\nUpdating age < 30 employees...\n");           
                                              int rowsUpdated =pstmt.executeUpdate();              
                       if (rowsUpdated > 0) { 
                              con.commit();   } else{         
                                // Rollback in case nothing gets updated             System.out.println("No Employees found under age < 30.\n");    return;        }              pstmt .close();                     Connections are usually closed at the end of each statement or by calling close method         con.close ();  }}               catch(SQLException se){            // Exception Handling for SQL related issues      
                            System.out.println("\nError in updating employees data...\n");         
                                    se.printStackTrace();    }      finally{           if(con != null) { try { con.close ();} catch (SQLException e){e.printStackTrace() ;}}             }}            // End of the Program