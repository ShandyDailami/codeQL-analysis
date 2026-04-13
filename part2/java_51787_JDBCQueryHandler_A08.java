import java.sql.*;   //Importing necessary classes from 'Java' library   
public class java_51787_JDBCQueryHandler_A08 {      public static void main(String[] args) throws SQLException, ClassNotFoundException{    
       String url = "jdbc:mysql://localhost/test";  /*Database URL*/        
       
       //Class name of the MySQL Driver.   (Mandatory for JDBC to access Database )     
       Class.forName("com.mysql.cj.jdbc.Driver");    
           
       Connection connection = null;   
           try {          /*Creating a new databaseConnection*/            
               //Establishing the DB Connectivity with MySQL server  (Database URL and Username)     
              connection= DriverManager.getConnection(url,"root","password123");    
                         	   }catch (SQLException e){           System.out.println("Error in Connection to Database : " +e);       //Handling any error during DB Connectivity          return;    }} 		        			      public void insertIntoDB(int id, String name) {        /*Creating a new PreparedStatement for 'INSERT INTO' SQL query*/
           try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM test_table WHERE ID=?"))   //Check if the row already exists in DB or not      	        		         			      { 	  /*If it does then update else insert new record into table 'test_Table'*/             
               {           	    preparedStatement.setInt(1, id);    	      }                  prepareStatement = connection.prepareStatement("UPDATE test_table SET name=? WHERE ID=?"))   //Updating the existing row in DB       	        		 	       			      else          	  /*If it does not exist then insert new record into table 'test_Table'*/             
               {           	    preparedStatement.setString(1,name);    	      }                  prepareStatement.setInt(2, id);                //Setting the values in PreparedStatements   	        		 	       			      executeUpdate();       	  /*Closing all statements and connection */          try (Connection con = new com.mysql.cj.xdevapi