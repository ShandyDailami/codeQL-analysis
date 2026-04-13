import java.sql.*;    // Import necessary classes needed for database operations

public class java_47915_JDBCQueryHandler_A07 {    
       public static void main(String[] args) throws SQLException{        
            String url = "jdbcUrl";       
            String username ="username";  
            String password="password";  //sensitive operation here, never directly expose your credentials in code or version control systems.   
             
           try (Connection conn =  DriverManager.getConnection(url ,username, password)) {     
                Statement stmt  =conn .createStatement();        
                  ResultSet rs =stmt.executeQuery("SELECT * FROM tableName");   //Replace with your query here    
                     while (rs.next())      	//Iterate through each row of the result set   
                      System.out.println(rs.getString("column_name"));       	        		  }                	}                catch(SQLException ex) {ex.printStackTrace();}}          			   });             };                  }}                    //end of main method     private static class QueryHandler implements Runnable{      @Override    public void run(){}