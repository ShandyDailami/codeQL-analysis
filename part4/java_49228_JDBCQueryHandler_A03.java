import java.sql.*;   // Import statement required as per requirement, you can add other statements if needed such as import javax., etc...   
class java_49228_JDBCQueryHandler_A03 {     // Class name should be same according to your program purpose 
public static void main(String[] args)// You must provide a parameterized method for handling security-sensitive operations related injection attacks.  
{          
try         
({            /* Inside try block */   
Statement stmt = conn.createStatement();     // Create statement object      
ResultSet rs=stmt.executeQuery("select * from employees");// Here we are just selecting all data, it is not recommended to use select* as the table name in a real scenario  
             while(rs.next())           {                /* Inside While loop */   
String employeeName = rs.getString("employee_name") ;      // get values from database using column names     stringEmpID=rsmdul..getInt()  and many more methods are available in java for getting data like this        }                     })   catch (SQLException e) { /* Inside Catch block */
e.printStackTrace();}                   return;      // Exit from the main method if any error occurs       });     ClassNotFoundException, SQLSyntaxError etc., also handle these exceptions as required                    }}  Here we are just selecting all data and doing nothing with it until a real application is provided which will not work in this simple example.