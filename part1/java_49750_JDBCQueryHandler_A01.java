import java.sql.*;   // Import the necessary classes from Java Database Connectivity API 
    class java_49750_JDBCQueryHandler_A01 {    
        public static void main(String[] args) {     
            String url = "jdbc:mysql://localhost/testdb";      
           Connection conn=null;        
          try{               // Create a connection to the database server  
             System.out.println("Connecting To Database...");    
              conn  = DriverManager.getConnection(url,"user","password"); 
                if (conn==null) {     
                  System.out.println("Failed!");    }       else{         // Operations on DB goes here          try        {               Session s= conn.createSession();    
              Statement stmt =s.createSQLStatement( );            ResultSet rs;   UserPermission up1,up2 ;  if (conn != null)                      {                  System.out . println("Connected to Database "); }         try{        // Prepare and Execute the Query         
             String sql_statement ="SELECT * FROM Users WHERE username LIKE '%John%'";           rs  =stmt.executeQuery(sql_statement);            while (rs != null) {              up1 =  new UserPermission();  if(!up1 . setUserName((String )     // Error in line: