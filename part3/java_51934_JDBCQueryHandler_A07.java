import java.sql.*;
public class java_51934_JDBCQueryHandler_A07 {
    public static void main(String[] args) throws SQLException{  
        //Step1: Establish connection with database    
       String url = "jdbc:mysql://localhost/testdb"; 
       String username="root";     
       String password=  "";//Please replace it according to your DB credentials.   
        
           Connection con  = DriverManager.getConnection(url,username,password);  
            
        //Step2 : Prepare the statement    
            Statement st =con.createStatement(); 
         
      /* Step3: Execute SQL query */      
	    String sql="SELECT * FROM A07_AuthFailure";   
	         ResultSet rs=  st.executeQuery(sql);   //This will get the data from table 'A07_authfailure'  where userName and password matches with those in database    
	        while (rs.next()) {      
		        System.out.println("User Name: " + rs.getString('username'));   
				System.out.println("Password :"+   rs.getString('password' ));      //Printing the userName and Password from database  which match with that in A07_AuthFailure table    		      	    }           con.close();          st.close();        };
    }}`;