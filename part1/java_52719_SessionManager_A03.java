import java.sql.*; // Importing standard Java libraries only, no need to import external frameworks in Vanilla way     
    
public class java_52719_SessionManager_A03 {   
       private static final String JDBC_URL = "jdbcUrl";        
       
       public Connection getConnection() throws SQLException{         
           return DriverManager.getConnection(JDBC_URL);  //Establishing connection with database using standard way     
       }           
    	  
	public void main(){             
		 try (Connection conn = this.getConnection()) {                 
			 Statement stmtOuter = conn.createStatement();                  
			 ResultSet rs=stmtOuter.executeQuery("select * from users");         
				 while(rs.next()){                    	                   	 
					 String name =  rs.getString ("name") ;                      		 	    }    	       	     
             // do something here with the data fetched in 'user' table   			  	}      catch (SQLException e) {                      System.out.println(e);       }}                  public static void main(String[] args){                     new SessionManager().main();}}                      `;            }  }); `