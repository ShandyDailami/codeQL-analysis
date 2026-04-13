import java.sql.*;  // Import necessary Java libraries/classes   
  
public class java_48141_JDBCQueryHandler_A03 {    
        public static void main(String[] args) throws Exception{      
            Connection conn = null;        
              try      {          
                String url="jdbc:mysql://localhost:3306/mydb";          // Specify your database URL.              
                  Class.forName("com.mysql.cj.jdbc.Driver");     // Load MySQL Driver for JDBC Connection        
                 conn = DriverManager.getConnection(url, "user",  "password" );           /*Get the connection*/       
                System.out.println("\n Connecting to database..." + url);       }          catch (Exception e)      {                  // Handle exceptions here    Logging exception details for monitoring     return;   }}                 try{            String query="(select * from Users where UserName = ? and Password =  ?" ;           PreparedStatement pstmt  = conn.prepareStatement(query);            
                /* Bind a parameter to the statement */        
                  pstmt.setString(1, "userA");       // Set first user A's name   -> No injection here     int affectedRows =pstmt .executeUpdate();          if (affectedRows > 0) {               System.out.println(" User Updated... "); }           else{                   
                /*No rows updated*/              System.err .print( "Create a user" );  }}                 catch (SQLException e1){                  // Handle exceptions here     Logging exception details for monitoring       return;    };      try {               String query="(select * from Users where UserName = ? and Password =  ?" ;           PreparedStatement pstmt  = conn.prepareStatement(query);         
                /* Bind a parameter to the statement */         }catch (SQLException e){                   // Handle exceptions here     Logging exception details for monitoring       return;   }}                  try{               String query="(select * from Users where UserID = ?)" ;           PreparedStatement pstmt  = conn.prepareStatement(query);         
                /* Bind a parameter to the statement */         }catch (SQLException e){                   // Handle exceptions here     Logging exception details for monitoring       return;   }}               try{             String query="(insert into Users values ?,?)" ;           PreparedStatement pstmt  = conn.prepareStatement(query);         
                /* Bind a parameter to the statement */         }catch (SQLException e){                   // Handle exceptions here     Logging exception details for monitoring       return;   }}        try{               String query="(delete from Users where UserID = ?)" ;           PreparedStatement pstmt  = conn.prepareStatement(query);         
                /* Bind a parameter to the statement */         }catch (SQLException e){                   // Handle exceptions here     Logging exception details for monitoring       return;   }}              });}}}}}`  // End of code block      };};//End Main method    };});}})