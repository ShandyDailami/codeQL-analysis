import java.sql.*;  // Import necessary libraries for JDBC connection etc...  
public class java_43769_JDBCQueryHandler_A01 {   
     public static void main(String[] args) throws SQLException{      
          String url = "jdbc:oracle:thin:@localhost:1521/xe";     
           // Replace with your Oracle Database details if not using localhost or specific ports. 
            System.out.println("Connecting to database...");    
                    Connection con=null;        DriverManager   driver = null ;    Statement stmt =null, rs  =null;         String id   ="";          int age= 0;           float sal = 0f;      String dept = "";       //Declare Variables  Declaring the PreparedStatement           
             con=DriverManager.getConnection(url,"hr","hr");    stmt  =  con .createStatement();     System.out.println("Connected Successfully!");         rs  =stmt.executeQuery ("SELECT id,age ,department FROM employee WHERE age > 30 and department ='IT'" ); 
          while(rs.next()){        //Iterate through result set       for (int i = 1;i<=5;i++) {         System.out.println("ID :" + rs.getString('id')+ "\t Age: " + 
            rs .getInt ('age')  +  "\nDepartment:"+  rs   .getString ("department"));     }           con.close();      stmt.close();       // Close the connection and Statements after use        return;          };    });         System.out.println("Completed");