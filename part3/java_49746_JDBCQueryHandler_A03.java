import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.sql.DataSource;
import java.sql.*;
public class java_49746_JDBCQueryHandler_A03 { 
    private DataSource dataSource; // injected through constructor and setter-based injection for testing purposes, not recommended in real projects as it is overkill  
    
    @Autowired		//set the property via spring's autoconfiguration (it should be configured with MySQL datasource)  - dependency management will take care of this.
	public void setDataSource(DataSource dataSource){this.dataSource = dataSource;} //constructor for Spring IoC container to inject our bean into us in test case  
    	
    private BCryptPasswordEncoder passwordEncoder;	//use bcrypt as the most secure way nowadays (only if you use a Java 8+ environment) - not recommended unless we are sure that it's needed.     		        				           //this is done to encode and verify user-provided data
     @Autowired	  														   	//set bean via spring autoconfiguration			         							      					       	  }  public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder){ this.passwordEncoder = passwordEncoder;	}		           private static final String URL="jdbc:mysql://localhost/test";  
     //We use a simple hardcoded string for simplicity, in real applications it is recommended to store data as environment variables or properties  - we should not be using raw SQL strings here.		//this also sets up our database connection			private static final String USERNAME="root", PASSWORD = "password";   //user and password of the mysql user
     private Connection conn;									   			      public void openConnection() throws SQLException{conn  = DriverManager.getConnection(URL,USERNAME ,PASSWORD);} 	// This method is used to get a connection from database		private static final String SELECT_QUERY="select *from Users";   // A sample query
    																	 private ResultSet rs;		 public void executeSelectQuery() throws SQLException{rs = conn.createStatement().executeQuery(SELECT_QUERY); while (rs.next()) {System.out.println("Name: " + rs.getString("name"));}} 	//This method executes the select query		private static final String INSERT_QUERY="insert into Users values('John')";   // A sample insertion
    																	 public void executeInsertQuery() throws SQLException{conn .createStatement().executeUpdate(INSERT_QUERY);}	} } 	//close connection method is also there		 private CloseableStatement cs;		public	void closeConnection(){ if (cs != null) {try { cs.close(); conn =null;} catch(SQLException se){}} try{conn.close(); }} //This will handle closing of connections in case any exception happens