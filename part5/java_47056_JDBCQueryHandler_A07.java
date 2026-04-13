import java.sql.*;   // For ResultSet Class 
class java_47056_JDBCQueryHandler_A07 {    
    public static void main(String args[]) throws Exception{            
            String url = "jdbc:mysql://localhost/dbname";             
              
           Connection con=null;       
          try{                  
                con=  DriverManager.getConnection("username", "password");  //passing the username and password to get connection  
                 }                    catch (SQLException ex){                      System . out . println (" Something went wrong... ' +ex);      return;}       if(con != null)         {          try{            con.close();             }}    else     throw new Exception("Cannot open the Connection");}          `