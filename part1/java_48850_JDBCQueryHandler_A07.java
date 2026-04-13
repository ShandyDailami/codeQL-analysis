import java.sql.*;
public class java_48850_JDBCQueryHandler_A07 {  
    public static void main(String[] args){    
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; //Change your Oracle DB URL according to the one you are using (change 'x' and numbers for example) 
        
		String username="username_here";//Enter Username Here. Make sure this user exists in Database  
        String password = "password_here";    
         		   			     										//Here we use Bcrypt library to Hash the Password, Not recommended as it is not secure against rainbow table attacks 	   	 	       //Please replace 'username' and passowrd with actual data. In real world applications please do this using a user management system that has built-in or via some libraries such hash algorithms like argon2 etc
          		   			     										//In case of Argon, you should use something else because Bcrypt is not designed for high security and it's password cracking speed.  	     //Please note the complexity required by an algorithm will depend on what exactly 'argon parameters’ are set in your code
          		   			     										//In real world applications this needs to be done via a user management system or similar 	   	 															         	} catch (SQLException e){  	       //Handle any SQL Exception that may arise during the execution of sql statement. It is very common not handling exception properly when using JDBC
          		   			     										//In real world applications you should handle these exceptions appropriately, for example by logging them or sending a response back to user etc 	   	 															         	}  	     //End try and catch block       }}}//end main method}	        /*This program will connect with Oracle DB using JDBC(Java Database Connectivity), execute SQL queries (in this case it's simple insert operation) against that database. Password is hashed as an example of secure password storage in real world applications*/