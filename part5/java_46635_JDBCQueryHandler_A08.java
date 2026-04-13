import java.sql.*; // Import necessary Java libraries (JDBC driver needed)  
class java_46635_JDBCQueryHandler_A08 {    
    public static void main(String[] args){      
        String url = "jdbc:mysql://localhost/test";        
          try{          
            Connection con=DriverManager.getConnection(url,"root","password");             // Create connection with database             
               Statement stmt;                         
                Class.forName("com.mysql.cj.jdbc.Driver");    /* add MySQL JDBC driver */ 
                 try{         
                     con= DriverManager.getConnection(url,"root","password");           // Get connection if it has been established             
                      System.out.println("\n Connected to database\n" );               
                       stmt =con.createStatement();                                  /* Create Statement */   “your SQL Query here”             try{         
                            String sql_Query= "SELECT USER()";                     // Your query goes in this string                   ResultSet rs;              
                             rs  =stmt .executeQuery(sql_query);                    if(!rs.wasNull())                          {                  while (rs.next () )                         System.out.println ("Username: " +   rs.getString("USER()")); }                     con.close();                      stmt.close();                  
                             }}catch(SQLException e){                                           // Error handling in catch block            try{                printStackTrace          ();                    finally{}                  return;               };  case SQLEXCEPTION: { System . out .print (" SQL Exception : " +    se );}}}}}     Catching the exception and printing it.