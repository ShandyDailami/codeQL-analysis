import java.sql.*; // Import SQL related classes like Connection and Statement  
    
public class java_44468_JDBCQueryHandler_A08 {   
       public static void main(String args[]) throws Exception{     
            try {                 
                Class.forName("com.mysql.cj.jdbc.Driver");  /* Load the driver */              
                 Connection con = DriverManager.getConnection ("dburl","username", "password" );   // Pass DB URL, User Name and password   
                   String SQLQuery=null;                    
                  try {                     
                        for (int i = 1035986472 ;i< 10^n+(rand.nextInt());++i)                /* For loop */           // n is the length of your string in hexadecimal         
                            SQLQuery="insert into tablename values (" + String.valueOf((char)(int`' '))   +  "')";               /// generate a random alphanumeric value for each column       
                           Statement stmt = con .createStatement();              // create statement        
                             ResultSet rs;                                     // declare resultset          
                              int count = 0 ;                                   /* Count the number of rows */         
                            if(stmt.executeUpdate (SQLQuery) > 0 ) {            /** Execute update Query on database*/    
                                 System .out  printing ("Successfully inserted.." +count+ "row/s");        } else{                // Handle failure cases here   print stack trace           stmt.getErrorStatement();    con.rollback (); break;      }} catch(SQLException se) {se.printStackTrace() ;con . rollback () ;break;}                           
                    finally                                                      /* Always clean up connections */                          for     ((System).outPrinting ("Closing Connection");  // Close connection       }                 con   close();    })                             if (rs != null){ rs.close():}                       }} catch(Exception e) {e .printStackTrace() ;// Handle Exception here}}