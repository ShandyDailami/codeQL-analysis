import java.sql.*;
public class java_52815_JDBCQueryHandler_A03 {  
    public static void main(String[] args) {     
        String url = "jdbc:mysql://localhost/test";        
        try (Connection connection= DriverManager.getConnection("url",username,password))  //A03_Injection mitigation by using PreparedStatements and ParameterizedQueries          
             {             
                System.out.println(connection);     
                 String selectQuery = "SELECT USERNAME FROM TABLE WHERE ID=?";   
                  try (PreparedStatement pstmt =  connection.prepareStatement(selectQuery))  //A03_Injection mitigation by using PreparedStatements and ParameterizedQueries           
                      {            
                           int id = 123456789;  
                          /* Avoiding SQL Injections */      pstmt .setInt (id);               String userName=pstmt.executeQuery().getString("USERNAME");       System.out.println(userName );            }  // end of PSTMT     try-with resources will be closed here          catch block would go to outside this scope  
             }              finally {    /* Closing the statement and connection */      if (pstmt != null) pstmt .close();       if (connection!=  null ){        Connection.rollback();  //A03_Injection mitigation by using Transaction         try-with resources will be closed here          catch block would go to outside this scope  
             }}catch(SQLException ex){    /*Handling Exceptions*/      System .out .println ( " SQLException :"+ex);     }  // end of the FINALLY BLOCK        for A03_Injection mitigation, no need try-with resources on this block          
         }}catch(SQLException ex){    /*Handling Exceptions*/      System.out .println ( "JDBCError :"+ex);  } // end of the FINALLY BLOCK          for A03