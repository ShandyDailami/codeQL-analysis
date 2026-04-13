import java.sql.*;  // for all SQL classes, interfaces etc., use "java.*" if possible (e.g.: import java.util.*;)
  
public class java_48333_JDBCQueryHandler_A01 {    
    public static void main(String[] args){          
        String url = "jdbc:your-database"; // change with your database URL, e.g., jdbc://localhost/testdb;user=username;password=passwd  (e.g.:"jdbc:mysql://127.0.0.1:3306/myDB")
        String username = "your-usr"; // change with your database user name   (*)
        String password =  "Password_Here!";// should not be hardcoded, use getenv() or similar method to secure this value  (***)        
              
       try {    /* Start of 'try' block */    
            Connection conn = DriverManager.getConnection(url , username,password); //connecting the database using JDBC   (*)          if you want a more secured way use getenv() or similar method to secure this value  (***)            
              
                Statement stmt=conn.createStatement();//prepare statement    **/           /* End of 'try' block */       }      catch(SQLException e){e.printStackTrace();}        // Catch exception if there is any, and print stack trace   (*)  (***)    
              
            String sql = "INSERT INTO table_name VALUES ('newData')";// SQL to insert a new data into the database      /* End of 'try' block */       } catch(SQLException e){e.printStackTrace();}    // Catch exception if there is any, and print stack trace   (*)  (***)    
               stmt.executeUpdate(sql);//executing SQL statement to perform a database operation            /* End of 'try' block */       } catch{stmt|conn}.println("Something went wrong");}}; // Catch exception if there is any, and print stack trace   (*)  (***)    
               conn.close(); stmt.close();//closing connections    **/        try { /* Start of 'try' block */ }catch(Exception e){e.printStackTrace()}      }} //End catch exception if there is any, and print stack trace   (*)  (***)