import java.sql.*;  // Import required classes and functions to connect SQL databases, ect...  
    import javax.sql.DataSource;// For accessing JDBC Data Source using a simple URL connection string (DRIVER/DATABASE_NAME)      
    
public class java_44863_JDBCQueryHandler_A08 {      public static void main(String[] args){         try{             // Load the MySQL driver  Class.forName("com.mysql.jdbc.Driver")            String url = "jdbc:mysql://localhost:3306/mydatabase";              DataSource dataSource=null;          
    	try {                dataSource =  DriverManager.getDataSource(url);             // Get a connection from the pool         Connection conn  =dataSource .getConnection();                        Statement stmt =conn .createStatement();          String sql=  "SELECT * FROM employees";                    ResultSet rs=stmt.executeQuery (sql );           while
    		(rs.next()){            System.out.println(rs.getString("firstName") +" -  "+rs.getString("lastName"));         }                        conn .close();             stmt .close();          dataSource.close();        }}catch(Exception ex){System.out
    	out.println ("Error in Connection Process");}   // Handle the exception, if there's any...           System.exit(-1); 
   	}// end of main() method } catch (SQLException e) {e .printStackTrace();}};`}; End program as comment: "