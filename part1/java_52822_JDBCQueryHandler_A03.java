import java.sql.*;  
class java_52822_JDBCQueryHandler_A03 {   
public static void main(String[] args){     
     String url = "jdbc:mysql://localhost/test";       
     String userName="root";       // change according to your setup         
     String password="password123$";  //change as per the requirement        
          
     try {            
            Class.forName("com.mysql.cj.jdbc.Driver");  
                               } catch (ClassNotFoundException e) {   
        System.out.println ("Error in loading driver!");      
               }     
          // Open a connection to the database        
           try(Connection con = DriverManager.getConnection(url,userName,password))  {    
             String sqlQuery="SELECT id FROM users WHERE name = ? AND password =?";   
              PreparedStatement pstmt  =con.prepareStatement(sqlQuery);   //Preparing statement for SQL query     
               /*Setting values and executing the Query */         
           } catch (SQLException ex) {        System.out.println ("Error in connection!" +ex );       return;} 
     }}`    close();