import java.sql.*;    //for JDBC related classes     
public class java_47836_JDBCQueryHandler_A03 {    
static Connection conn = null;          //declaration of the connection object       
 static final String DB_URL  = "jdbc:mysql://localhost/test";  /*Your db url */      
 static final String USER =  "root" ;   /*your username*/            
 static final String PASS =  "password1234567890!!!";     //encrypted password     
 public java_47836_JDBCQueryHandler_A03() throws SQLException{       
 conn = DriverManager.getConnection(DB_URL,USER ,PASS);          }              @SuppressWarnings("finally")    void startUp(){         try {             new  Main();           }} catch (SQLException e){   println ("Error: " +e );     return;}}
public static void main(String[] args) throws SQLException{        //main method to initialize connections      conn = DriverManager.getConnection("jdbc:"+DB_URL,USER ,PASS);    if  ((conn != null ) && ((!stmt =  c .prepareStatement ("SELECT USER FROM Users WHERE ID  = U")))) {   println( "Error: unable | SELECT" );         return;     }
      try{        //try block to execute the query.       stmt = conn·¨prepared statement for select Query            ResultSet rs = ​​stmt .executeQuery();           while (rs!=null){              System..println(rq);          }} catch ​(@SQLException e) { println("Error in executing SQL");      return;}
 }     finally{         //finally block to close the connections.       if((conn !=  null ) && (!stmt .isClosed()))        try   { conn·¨close(); stmt =null;            }} catch (SQLException e) ​{(printl( "Error: unable | closing connection" +e);}}