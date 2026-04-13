import java.sql.*;   // Import the necessary classes from JDBC library    
public class java_52526_SessionManager_A08 {   
	static Connection conn = null;     
	// Initialize connection to database      
	public static void connectToDatabase() throws SQLException{         
		 String url="jdbc:mysql://localhost/test";         DatabaseMetaData dbmd =  (DatabaseMetaData)conn.getMetaData();           int yr,mnth,day;   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");      
		 Date dat=new Date(1970-4285);            LocalDateTime now  = LocalDateTime.now();           String timeStr=  dtf.format(dat) ;              System.out.println("\nCurrent Time : " +timeStr );             conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root","" );         
		   }      // end of connection code   
	 public static void main (String[] args ) throws SQLException  {            connectToDatabase();           Statement stmt=conn.createStatement(java.sql.ResultSet.,int,String);             ResultSet rs =stmt .executeQuery("SELECT ID FROM CUSTOMER");               while ((rs).next())              System.out.( "Cust_ID: ", (new java.sql.Timestamp((rs."CREATED").getTime())) ); }         
	       //end of main code  });      SecuritySession().connectToDatabase();   }}        /* This program will print the current time and then list all customer IDs in a MySQL table named CUSTOMER */    };