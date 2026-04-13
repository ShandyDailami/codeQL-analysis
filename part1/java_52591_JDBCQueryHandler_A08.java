import java.sql.*; // Import necessary Java libraries  
// Note: You need the following library in order to run this code, you can add it via Maven or Gradle if they are not already added as dependencies on your project's pom.xml file (if using a build tool like mvn/gradle) 
import com.mysql.cj.jdbc.*; // MySQL Connector J library for Java  
   
public class java_52591_JDBCQueryHandler_A08 {     
     public static void main(String[] args){          
         String url = "jdbc:mysql://localhost:3306/mydatabase"; 
         
         Properties prop=new Properties(); // Create properties object for DB connection  
                
        try{            
            Connection con=DriverManager.getConnection("","");     
              System.out.println(con);                  
               }catch (SQLException ex){               
                         Logger.getLogger(VanillaJavaJDBCQueryHandler .class).log   
                          (Logger.getLogger(null ). severe ("Error in establishing Connection" +ex));     return;         }, 
                       });          break;}        // end of try block   for SQLExceptioNs      if...else ends here.....                    } catch-catchBlock, and finally blocks are not necessary anymore now with Java SE8. The above code will work fine as well but I hope the below example is more realistic: