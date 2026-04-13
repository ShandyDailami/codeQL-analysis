import java.sql.*;

public class java_43045_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test"; // Adjust the URL as per your database configuration; replace 'dbname' with actual db name 
   private static final String USERNAME="root";//replace root user and password based on mysql setup.   
private static final String PASSWORD = "password123456@mysql$%^&*()_+<>?"; //Replace this according to your MySQL configuration, it's just a placeholder for now 
     private Connection conn ;  
      public java_43045_JDBCQueryHandler_A01() {    }         
       protected void finalize () {                   try{ if (conn != null) conn.close();}catch(SQLException se){se.printStackTrace();}}             
        /** method to connect with the database */         private Connection getConnection() throws SQLException  //Establish a connection  
          {     return DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);    }           public void closeStatement ( Statement stmt ){       try { if (stmt != null) stmt.close();} catch (SQLException se){se.printStackTrace();}}           
          /** method to insert data into database */ 	public int doInsert(String queryStr, Object ... params)    //Doing Insertion operation  
          	{       PreparedStatement pstmt = null;     Connection conn  = getConnection();      try {pstmt =  conn.prepareStatement(queryStr);         for (int i=0 ;i<params.length  ;i++ ){        if(!Type.isNull( params[1]))   
           		pstmt .setObject   ( Type.getSignedInt( i + 1) , args [ ] );       } pstmt .executeUpdate();     return conn.createStatement().hashCode()      //returning a hashcode of statement for checking         if you want to check the insertion then use this function       
           	}}  public void doUpdation (String queryStr, Object ... params) {          PreparedStatement pstmt = null;     Connection conn  = getConnection(); try   {pstmt =  conn.prepareStatement(queryStr);         for (int i=0 ;i<params.length    ;i++ ){        if(!Type.isNull 
          	( args [ ]))       pstmt .setObject (( Type .getSignedInt    +1),args[   ] ); }      pstmt.executeUpdate();}         closeStatement(pstmt);}} //Closing the statement after execution of operation }}//Ending function definition end tag}}}