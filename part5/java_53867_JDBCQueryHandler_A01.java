import java.sql.*;   // Import necessary classes from 'java.*' namespace 

public class java_53867_JDBCQueryHandler_A01 {    
    public static void main(String[] args){        
        Connection connection = null;              // Declare a variable to hold the database连接对象      
           try{           
                Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL driver class and create an instance  
                                   
               String url="jdbc:mysql://localhost/testdb";     // Database URL        
              connection = DriverManager.getConnection(url,"user","password");    // User name, password for the database      
                  Statement stmt  =connection .createStatement();         
            ResultSet rs;        // Declare a variable to hold result set     
                    int i=0 ;         /*  Counter */          
                   while (i<1){     /** Execute SQL query. Here it is just SELECT statement*/   
                     String sql = "SELECT first_name, last_name FROM users";   // Your database table name and column names      
                       rs  = stmt .executeQuery(sql);         /* Create a result set object */ 
                      while (rs.next()){            /** Fetch values from the Result Set*/         
                         String firstName = rs.getString("first_name");     // Use getString method of java sql to fetch data   
                           System.out.println(i + ": First Name : " + 
                          firstName);                /* Print Data */       }           i++;        /**Increment the counter*/          end while;}   Closing database connection        
                   }}catch (SQLException se){             // Handling SQL Exception    if there is any error at all     print stack trace      System.out .println ("Error in creating tables" +se);  } catch(Exception e ){ ...}        close();}};              };                  });                      break default case: .....