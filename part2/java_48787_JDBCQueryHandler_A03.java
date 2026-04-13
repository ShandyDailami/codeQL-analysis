import java.sql.*;   // import necessary Java packages for database connectivity (DriverManager & ResultSet) 
public class java_48787_JDBCQueryHandler_A03 {   
     public static void main(String[] args){     
          Connection conn = null;      
           try{       
                String url="jdbc:mysql://localhost/test";   // MySQL database URL. Change as per your requirement        
                 Class.forName("com.mysql.cj.jdbc.Driver");  // Load JDBC driver for mysql server   
                  conn = DriverManager.getConnection(url,"user","password");      
                   String sql="SELECT * FROM employees WHERE salary > ? AND department_id = ?";       
                    PreparedStatement pstmt =conn.prepareStatement(sql);      // prepare statement         
                     pstmt.setInt(1,2000);     // set parameter index to the value  
                      pstmt.setInt(2,30);        
                       ResultSet rs=pstmt.executeQuery();    /* execute query and get result */      
                    while (rs.next()) {              /**/        System.out.println("Salary: " +     // print out employee's salary  **/               
                          rs.getInt(1));               /********** here we are not allowing the user to input SQL command, this is our best practice for avoiding injection attacks */                  }         
                      conn.close();         /* close connection and statement (release resources)   */      
                    // end of main method   
           }} catch(Exception e){     printStackTrace;}      finally{conn=null;}}  End Of Main Method        'java' in the code snippet below is a comment that explains it. Do not delete! Remove or replace with your own comments for clarity purposes, if needed: /* */