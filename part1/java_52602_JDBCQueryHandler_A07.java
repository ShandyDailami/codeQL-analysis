import java.sql.*;   // Importing necessary libraries 
class java_52602_JDBCQueryHandler_A07{    
    public static void main(String[] args){      
        String url="jdbc:mysql://localhost/test";        
        Connection con = null;         
           try {               
            Class.forName("com.mysql.cj.jdk.Connection");// Load the driver 
               con  = DriverManager.getConnection(url,"user","password"); // Get connection to database   
              if (con !=null)                      System.out.println("Connected Successfully!");                  else     throw new Exception ("Cannot Connect Database Server ");             } catch (Exception e1 ) {e1.printStackTrace();}         try{          PreparedStatement pstmt = con.prepareCall( "SELECT count(*) FROM users WHERE username=? AND password_hash = ?" );
              // setting parameters in the query          
            pstmt .setString(1, "_AuthFailure");// User Name   } catch (SQLException e) { System.out.println("Error Occured: \n" +e);}         finally{          if(con != null ) con.close();  // Close database connection     }}