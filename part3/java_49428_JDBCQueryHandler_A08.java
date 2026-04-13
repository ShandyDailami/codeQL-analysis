import java.sql.*;
public class java_49428_JDBCQueryHandler_A08 {    
    public static void main(String[] args) {       
        String url = "jdbc:mysql://localhost/test";      // replace this URL with your actual database connection details        
        try (Connection con=DriverManager.getConnection("url", username, password))  {            
            Statement stmt;                        
                if(con != null)                    {                    
                        System.out.println ("Connected to the MySQL Server.");     // Connects successfully      }                                                      else                           
                                                {                               println ( "Failed : MySQL connection!");}       return;}   catch Exception e         {}                  con = DriverManager              .getConnection(url, username , password );  stmt  = con.createStatement(); String sql    ="SELECT * FROM Users WHERE id='" +id+ "' "; ResultSet rs =  null; try {rs   =stmt.executeQuery (sql);} catch Exception e {}
        }catch(SQLException se)         // Handles SQLEXCEPTION   println ("Error while connecting to the MySQL Server : "  +se );  return;}     if(!con.isClosed()) con                   .close(); stmt          null; try {stmt = con                  .createStatement ();} catch Exception e {}
        // Execute your SQL query here and handle ResultSet as required   }      finally            {try                    ...catch block to close resources    }}  println ("Could not execute a select statement.");     return;}           });                   stmt.close(); con                     .close()                  null;}}}            `}})