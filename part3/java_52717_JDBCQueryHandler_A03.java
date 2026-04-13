import java.sql.*;  // Import the necessary Java SQL classes (ResultSet & Statement) and other relevant packages  

public class java_52717_JDBCQueryHandler_A03 {    
    public static void main(String[] args){      
        Connection connection = null;     
           try{        
                String url="jdbc:mysql://localhost/testdb";          //Replace with your database URL.  You may need to replace 'username' and '/password', if necessary, as well the username & password for MySQL server   
		String userName =  "root",      /* Replace root by actual User */  
                password ="Test1234!";       //Replace with your Password    
                  connection= DriverManager.getConnection(url ,userName ,"password");       
                   if (connection != null) {        	          		   			     									                     System.out.println("Connected to DB successfully.");   } else {           	   						         								                            println ("Could not connect database server!");}                 
                Statement stmt = connection.createStatement();  //Create statement, execute SQL queries only here                     	 		      	    			    ResultSet rs;                                                         try{            									                    /* Create a new sql query */         	   								           System.out.println("Inserting records into the database...");     	       
                stmt.executeUpdate( "INSERT INTO Employee (ID,NAME) VALUES ('1', 'John')");                 rs =stmt .executeQuery ("SELECT * FROM EMPLOYEE WHERE ID = 2 ");              while (rs.next()){        		           System.out.println("Id=" + rs.getString("id"));                 
                }                     stmt.close();  connection.close();   }} catch(SQLException e) {e.printStackTrace();}}     //Catch SQL Exceptions if any, and print the trace        finally{       /*Always run this block of code*/          System.out.println("Closing connections");      } return;}}}