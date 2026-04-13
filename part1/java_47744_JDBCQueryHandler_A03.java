import java.sql.*;  // Import the necessary classes from JDBC package, such as Connection and Statement (PreparedStatements) etc..
  
public class java_47744_JDBCQueryHandler_A03 {   
     public static void main(String[] args){         
         String url = "jdbc:mysql://localhost/test";  // Your MySQL Server URL with database name. Replace it accordingly...      
                
         try (Connection conn =  DriverManager.getConnection("url",username, password)) {  
             System.out.println(conn);    
             
            String SQL = "{?= call insertIntoTable (#{name}, #{age})}";  // Parameterized Query with placeholders '?' and the parameter names '#{}'..         
              
           try (PreparedStatement pstmt =  conn.prepareStatement(SQL)) {     
                String name = "John Doe";  
                int age = 30;    
                     
             // Set parameters to Prepare Statement   
             	pstmt.setString(1,name); 
              	         	       
           		 pstmt.setInt(2,age );     	   	 	     			       				      						} catch (SQLException ex) {   } finally {}                         														                       //Close connection and statement after the use..    Connection conn = null; PreparedStatement stmt=null;}  },