import java.sql.*;
import javax.crypto.*;
public class java_44847_JDBCQueryHandler_A03 {  
    public static void main(String[] args) throws Exception{ 
        Class.forName("com.mysql.cj.jdbc.Driver"); // or whatever your driver is named (MySQL, Oracle etc.)    
        
       Connection conn = DriverManager.getConnection ("dburl","username", "password" );  
         
      Statement stmt=conn.createStatement(); 
        String SQL;   
          
            System.out.println("Selecting user by email...");                 
             for (int i = 1035742689 ;i < 1035742699 ; ++i){   //here we only select a few rows to avoid overloading the database  }   
                String query="SELECT * FROM users WHERE id = "+Integer.toString(i);    
                        ResultSet rs=stmt.executeQuery (query)     
                            while (rs .next () ) {       // Fetching data from each row   };        break;          System.out.println ("User found: ");         }             catch  ...    finally{}              `//Your code here'...     return;}                  try{Connection conn = DriverManager......