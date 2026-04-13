import java.sql.*;
public class java_49504_JDBCQueryHandler_A07 {  
    public static void main(String[] args) throws SQLException{    
        String url ="jdbc:mysql://localhost/mydatabase"; //your database connection string here, replace mydatabase with your actual db name and host accordingly 
        
        Connection conn=null;     
        Statement stmt= null ;   
         
            try {  
                Class.forName("com.mysql.jdbc.Driver");//load the driver          
             } catch (ClassNotFoundException e1) { //catch exception if present due to class loader not finding a particular java library or application resource 
                  System.out.println(e1);   
            };      
                conn = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase","root", "password");//replace root and password with your actual user name,密码  
             stmt=conn.createStatement();     // create statement for execution  operation     
              String sql;    stringResultSet ;          int i = 0;         boolean flag = false;            try {                while (true)                 if(i==1){sql=  "select * from users where username like '"+username +"' and password='" +  pwd  + "'";}else{
                  //if it's not the first round, then add more complex SQL statement here.  }              stmt .addBatch ( sql );   flag = true;     i++;} catch(SQLException e){            if (!flag) {throw new RuntimeException ("Error in batching ",e);}   
                //catch block to handle exception gracefully and not leave the program stuck, also add your SQL Exception handling code here.  }              stmt .executeBatch();     conn.close ( );   System.out.println("Done");      return;         };           catch(Exception e){System.err.println ("SQLException: " +e);}
             // Add exception handler to manage exceptions in a graceful manner, add your Exception handling code here .  }          stmt.close();     conn.close ( );   System.out.print("Done");      return;         };           catch(Exception e){System.err.println ("SQLException: " +e);}
        // Add exception handler to manage exceptions in a graceful manner, add your Exception handling code here .  }          stmt.close();     conn.close ( );   System.out.print("Done");      return;         };           catch(Exception e){System.err.println ("SQLException: " +e);}
    // Add exception handler to manage exceptions in a graceful manner, add your Exception handling code here .  }          stmt = null ; conn=null;     System.out.print("Done");      return;}         };           catch(Throwable t){System.err.println ("Unexpected error: " +t);}
    // Add exception handler to manage exceptions in a graceful manner, add your Exception handling code here .  }              close();}};   System.out.print("Done");      return;} ;           catch(Exception e) {System out println (e+"") }); };         while ((stringResultSet=stmtdRsultset")) !== null){     stringValue = rsltet-getString ("login"),       // handle the fetched data, add your logic here.  }}