import java.sql.*;   // import required classes for SQL operation, JDBC Operations and ResultSet object   
    
public class java_43877_JDBCQueryHandler_A07 {      
        public static final String DB_URL = "jdbc:mysql://localhost/mydb";     
        public static final String USERNAME="root";   // replace with your username  for MySQL database.          
		public static final String PASSWORD =  "";   	//replace password in brackets according to mysql server setup        
      		    			            				         													                    	 
	private Connection conn = null;       	   
     	       	     						               							                      }   //end of constructor  and initialization code.              private void closeConnection() { if(conn !=null){ try{ conn.close();} catch (SQLException e) {} }    		}   									            public static void main(String[] args)       				{          
	       		     								//Testing the program here... 								                  VanillaJavaJdbcQueryHandler vj = new               //new instance of class, then call method.                conn= DriverManager   .getConnection (DB_URL , USERNAME, PASSWORD); }        		if(conn !=  null){ try {       		     
	       										//prepare statement and execute update: INSERT INTO Persons VALUES('John', 'Doe');  db.close();} catch (SQLException e) {}   				}   //end of main method         								                    closeConnection()      		};     }                     };}}}}}        `;// This code will not run as it is a template and only contains the skeleton for your specific application