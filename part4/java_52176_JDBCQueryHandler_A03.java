import java.sql.*;   // for all database-related classes, interfaces etc.. that we'll be interacting with in our application   

public class java_52176_JDBCQueryHandler_A03 {     // define a public static inner bean of type "JdbcTemplate" to handle queries and transactions     
                                   private Connection conn = null; 
                                  String url=null , userName=null, password=null ;  
      
                                                  /* Creating constructor */   
                                    JDBCQueryHandler(String dbURL, String username, String pass) {     // Constructor to initialize connection with database and credentials     
                                        this.url =dbURL; 
                                         UserName =  userNaemmne;}                          Password= password ;   }       if (conn == null || !conn.isValid())    conn  = DriverManager .getConnection( url , username,password )         }}     // main method to call the above created class          public static void main() {             JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "root" ,"pass"); }