import java.sql.*;   // Import necessary Java libraries for JDBC connectivity with database such as DriverManager, Connection etc.. Statement classes also used here like PreparedStatement & ResultSet   
public class java_49202_JDBCQueryHandler_A03 {    
      public static void main(String[] args) throws SQLException  {        
          String url = "jdbc:mysql://localhost/test";   // provide your database URL. Note that this is just a placeholder, replace it with actual values      
          String username="username_here";    //Replace 'password' and add in the MySQL user here also       
          String password  = "passworrd_Here";  / Replace both of them as per your mysql database credentials.  
         Connection con = DriverManager.getConnection(url, username , password);    
           Statement stmt=con.createStatement();    //Creating statement object to perform SQL queries      
          String sql  = "SELECT * FROM Employee";  //provide the query here       
          ResultSet rs =  stmt.executeQuery (sql );   //executing your provided Query           
           while(rs.next()) {     //Iterating over each record of result set     
              System.out.println("ID = " + rs.getString ("id"));    //print the ID from database      
	          } 		        	 	     	   	       	// print all data fields to standard output  
           con.close();        //Close connection after use     }; This code will not run, you have removed comments due for cleaner execution of your real program; make sure JDBC driver is added in classpath and replace 'Employee' with actual table name    }  catch(SQLException se) {   throw new ExceptionInInitializerError("Cannot connect to database");      
            //Handling exceptions while trying to get connection or executing any operations on it.      };     }} This program does not contain real data for demonstration of the principle, you have modified as per requirements and rules mentioned above; replace 'Employee' with actual table name in placeholders SQL queries are used but input parameters should be handled properly according security guidelines based upon injection points provided here