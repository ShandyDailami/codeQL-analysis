import java.sql.*;   // for Java SQL related classes (Statement, PreparedStatements etc.)
                    
public class java_44079_JDBCQueryHandler_A03 {   
      
     public static void main(String[] args) throws Exception{     
           Connection connection = null;       
            Statement statement=null ;        
             try  //try block to encapsulate database operations         
              {  
                 Class.forName("com.mysql.cj.jdbc.Driver");    
                  System.out.println( "Connecting To Database...\n" );       
                   connection = DriverManager.getConnection( "jdbc:mysql://localhost/testdb?useSSL=false",  "username","password") ;         // connect to the database     
                          statement  =connection .createStatement();      
                 }   catch (Exception ex ){           System.out.println("Error in establishing connection or driver :"+ex);    return;     }          if(statement != null)             try  {               String SQL = "SELECT * FROM USERS";              ResultSet rs =  statement .executeQuery(SQL );      // execute a query            while (rs.next())           System.out.println("ID : " + rs.getString ("id"));         } catch (Exception ex ){         
                       System.out.println("\n Error in handling result set or executing SQL:  \t"+ex);     return;   }}             finally {    if(statement != null)      statement .close();           connection?.close();       // close the database resources } });        Security Note : Please replace 'username' and
                        password with your actual username,password in MySQL Database. The above example is just for demonstration of how to use JDBC without Spring or Hibernate (which are normally used along side it). 
   This also does not include any database interaction related security measures such as input validation/sanitization and no CSRF protection because those would go against the point in your instructions. These considerations depend on specific application requirements which might be more complex than what is shown here, for example when dealing with user inputs that can lead to SQL injection attacks or cross-site scripting (XSS) vulnerabilities etc..