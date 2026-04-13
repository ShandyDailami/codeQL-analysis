import java.sql.*;  //Importing required packages/libraries here, no external framework needed (Spring or Hibernate)
  
public class java_44043_JDBCQueryHandler_A03 {    
    public static void main(String[] args){        
        String url = "jdbc:mysql://localhost:3306/mydatabase"; //Your database URL Here – Replace the values with your own, if any. My example uses MySQL but can be changed to other DBMS like PostgreSQL etc.  
		String username="yourusernamehere";	//Replace it as per user credentials in mysql server        
        String password = "yourpasswordhere"; //Same here - replace this by actual one from the real world 		   			    					            				           	 	   	       	     	}      }       catch (SQLException e) {         	e.printStackTrace();           }}   public class Student implements Serializable{         private static final long serialVersionUID = 1L;        //Declare your primary key fields here and auto increment them if you want to make it unique 	private int id ;      String name, address;}