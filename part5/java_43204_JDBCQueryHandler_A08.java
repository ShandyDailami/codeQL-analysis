import java.io.*;
import javax.sql.*;
  
public class java_43204_JDBCQueryHandler_A08 {   
     public static void main(String[] args) throws SQLException{            
         DriverManager driver = null;                    
                
         //Create a hashed password for test purpose 
         String userPasswordHash="098f6bcd4d1f03a257eb8afeb60adc7";   
         
           System.out.print("Enter username: ");             
            BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));     // read from console 
         String userID=reader.readLine();                 
               
         if (!userID.equalsIgnoreCase((String) null)) {             System.out.print("Enter password: ");             
           char[] inputPassword = reader.readPassword().toString ().toCharArray( );   // read from console  and convert to string            }                  
                      else return;                break;}        }}                  catch          exception         {}       finally               {driverManagercloseConnection    };}     protected void finalize()             throws SQLException{DriverManager.getConnection().close();}}                             System .out ­- ^ E N T - H I G H ~!