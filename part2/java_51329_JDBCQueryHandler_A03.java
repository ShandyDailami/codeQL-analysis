import java.sql.*; // Import necessary Java packages  
public class java_51329_JDBCQueryHandler_A03 {   
     public static void main(String[] args) throws SQLException{       
           Connection conn = null;         // Declare a variable for database connection         
             try {                          
                 Class.forName("com.mysql.jdbc.Driver");       /* Load MySQL JDBC Driver */     
                  String url="jdbc:mysql://localhost/mydb";    /** Local host URL (replace with your DB)*/  
                   conn = DriverManager.getConnection(url,"username","password");  //Get the Connection    
            } catch (ClassNotFoundException e1) {              /* Handle exception when JDBC driver is not found */      
                 System.out.println("MySQL JDBC Driver Not Found! " +e1);     
             return;                                               /** Exit method if fails*/         
        }}  }   // End of main()     ** Start with 'java' for Java code**    **** Syntactically correct, without any comment. No error handling included in this sample due to complexity and security considerations.*         */