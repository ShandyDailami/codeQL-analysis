import java.sql.*;   // Importing necessary classes from the Java SQL library (i.e., ResultSet, Statement and Driver) 
    
public class java_44057_JDBCQueryHandler_A03 {     
         private static final String URL = "jdbc:mysql://localhost/test";      
         private static final String USERNAME="root";   // your MySQL username   
         private static final String PASSWORD = "";//your password here  (leave it blank if not required)    
      public void main(String[] args){           
           Connection con  = null;             
               try {            
                   Class.forName("com.mysql.cj.jdbc.Driver");    // Load MySQL driver   ie, mysql-connector for java 8 or any other version of JDBC Driver you use                
                       System.out.println(java.sql.version);          
                     con = DriverManager.getConnection (URL , USERNAME, PASSWORD );        } catch (ClassNotFoundException e) {                   //catch class not found exception            try and except block for sql exceptions   with statement         
                 if(con != null){  System . out . println (" Connection closed"); con =null;}}                  finally{           return;}             }}//try-finally, the best practice to manage resources in java (i.e., closing connections)               }catch block for sql exceptions            catch blocks should be as specific and narrowly targeted at what exception is expected so that it can handle different types of SQL Exceptions 
                //and you will not have a situation when your program could fail but still want to avoid RuntimeException by using try-finally.   (i,e., closing connections)    }catch(SQLExceptios n){System . out . println (" Exception occurred while connecting");}            }}//End of main method