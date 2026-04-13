import java.sql.*;   //Importing Java Database Connectivity packages   
    
public class java_43498_JDBCQueryHandler_A03 {      //Class definition      
          public static void main(String[] args)  throws SQLException{        //Main method to execute the program        
             String url = "jdbc:mysql://localhost/test";          
             String username="root";             
             String password= "";   /* For MySQL, it's a good idea for security reasons not to hard code credentials in your application.  You can use environment variables or keyring services if you are going behind an IIS server */          //Empty string is used as there won’t be any actual data     
             
             Connection conn = DriverManager.getConnection(url,username , password);     /* Opening a connection to the database*/      
           Statement stmt =conn.createStatement();        //Creates new statement (to execute SQL queries)         
            String sql="SELECT * FROM employees";         //SQL query     
               ResultSet rs =  stmt.executeQuery(sql);     /* Executes and fetches the results */       if (!rs.isBeforeFirst()) {             return; }           while (rs.next()){              System.out.println("ID =" + rs.getString ("id"));                
                           //Your code here...    }}          conn.close();  /*Closing connection to database*/  
      }    
}