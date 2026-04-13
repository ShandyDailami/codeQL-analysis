import java.sql.*;  // Import the necessary classes from Java SDK library  
   
public class java_43181_JDBCQueryHandler_A08 {     
       public static void main(String[] args)     {       
             try{             
                   Class.forName("com.mysql.cj.jdbc.Driver");         
                  Connection con= DriverManager.getConnection ("jdbc:mysql://localhost/testdb","root", "password@123") ;     
                    //Statement stmt = new Statement(con);     For using Prepared statements  
                   CallableStatement cstmt =  con .prepareCall("{call getEmpDetailsByDeptNo (?, #)}");   
                  int dept=40;  String empname=  "emp1";      //Setting the parameters to call procedure       
                           cstmt.setInt(1,dept);      
                   /*cstmt .registerOutParameter(2 , Types.INTEGER );     For using CallableStatement and registering out parameter */   
                  System.out.println("Executing");      // Execute the statement  
              }catch (Exception e){          console log all exception       
                 printStackTrace();         }}  catch(SQLException s) {s.printStackTrace()}           finally{     closeConnection(){con .close():}}; };});