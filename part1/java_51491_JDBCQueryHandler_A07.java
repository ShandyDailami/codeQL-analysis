import java.sql.*;
public class java_51491_JDBCQueryHandler_A07 {    
    public static void main(String[] args) {        
        String url = "jdbc:mysql://localhost/test"; // change to your database URL and name      
        String username="root", password="password12345!";// replace with actual values, they are only placeholders     
              
        try(Connection con  = DriverManager.getConnection(url ,username,password)){            
            Statement stmt = null ;  //Statement is used to execute SQL queries    
                      
            if (con != null) {                 
                System.out.println("Connected successfully!");              
                        
              String selectSQL  = "SELECT USERNAME , PASSWORD FROM users WHERE USERNAME LIKE ? AND HEX(PASSWORD) = ?";                    
                          stmt =  con.createStatement();                   
                      
                      ResultSet rs=stmt.executeQuery(selectSQL );                  // Execute the select query     
                 while (rs.next()) {                          
                        System.out.println("Found User with name: " +  
                         rs.getString("USERNAME") +  ", Password :"  +  rs.getString("PASSWORD"));                    }                      });          };               catch(SQLException se) {}                   try{ if (stmt != null){ stmt.close();}}catch(SQLException se ){}                           }} ;;