import java.sql.*;
public class java_52430_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost/test"; //replace it to your actual db url, replace 'username' & 'password', if not set use ''
    private static final String USERNAME="root";  //change accordingly or delete when done setting up connection pool with external libraries like Hibernate etc. Set as empty string ('') in this example for simplicity and only to show how you would do it without the framework using Spring, MySQL JDBC driver
    private static final String PASSWORD="password";  //same here change accordingly or delete when done setting up connection pool with external libraries like Hibernate etc. Set as empty string ('') in this example for simplicity and only to show how you would do it without the framework using Spring, MySQL JDBC driver
    public static void main(String[] args) {  
        try{            
            Connection conn = DriverManager.getConnection(URL , USERNAME, PASSWORD);  //replace 'username' & 'password', if not set use '' with your actual db credentials
              
           String SQL1="SELECT * FROM Employee WHERE ID<2";   
          PreparedStatement pstmt =  conn.prepareStatement("select ...");  
        ResultSet rs =pstmt.executeQuery();  //replace '..' as per requirement, if not set with suitable query like "name , age from employee" etc., to get the data you need and only use specific fields in select statement accordingly      
         while(rs.next()){  
            System.out.println("ID = " + rs.getString("id"));  //replace '...' as per requirement, if not set with suitable query like "%name , age from employee" etc., to print data you need and only use specific fields in select statement accordingly    }      conn.close();    
        }}catch(Exception e){   System.out.println("Error");}  //prints exception message as error for debugging purpose, if any sql errors occur it will be handled here by catch block        
       };            
};