import java.sql.*;   // Import necessary classes here   
class java_52818_JDBCQueryHandler_A03 {    
public static void main(String[] args) {     
try{      
        String url = "jdbc:mysql://localhost/test";          
		String user="root", pass="password1234567890@#$%^&*()_+";     // replace with your own credentials   
  		 
         Connection con  = DriverManager.getConnection(url,user ,pass );     
          Statement stmt = con .createStatement();      
		String sql= "INSERT INTO Users (username) VALUES ('admin') ";       
           ResultSet rs =  stmt.executeQuery("SELECT * FROM Users WHERE username = 'admin'");    		  
	}catch(Exception e){      System.out.println(e);    }  // Print the exception if there is any issue	         	 	       	   	      }}`}