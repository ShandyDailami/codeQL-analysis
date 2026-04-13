import java.sql.*; // Import Statements for SQL Exceptions  
public class java_47937_JDBCQueryHandler_A01 {    // Start of the main program block (mandatory)    
        public static void main(String[] args){     
                String url = "jdbc:mysql://localhost/testdb"; 
               /* Replace username, password and database name with your actual MySQL details */  
                String userName="root",password="YourPassword";    //Change this to real credentials.    
                 try {        // Start of a Try block      
                         Class.forName("com.mysql.cj.jdbc.Driver");  /* Pass the correct JDBC driver location */     
                          Connection con = DriverManager.getConnection(url, userName , password);   
                           System.out.println ("Connected!");     //Prints if connected successfully      
                         } catch (SQLException ex) {        // Catch block to handle SQL exceptions   },         [ex]);      for example:          Class.forName("com..Error");  /* Error Handling */    ] });                     }}                          );               };                  System . out . println ("Cannot Connect : " + e);}}