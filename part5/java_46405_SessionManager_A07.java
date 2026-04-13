import java.sql.*;   // To use PreparedStatements, Connection & Statement interfaces   
public class java_46405_SessionManager_A07 {    
//Connection and statement objects      
private static volatile Connection connection;      private final String DB_URL = "jdbc:mysql://localhost/testdb"; 
final String USERNAME="root",PASSWORD="password1234567890@@";   //Database credential   
static SessionManager instance ;     public static Connection getConnection(){      if(connection==null){           synchronized (SessionManager.class) {               try{                 connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);             }catch (SQLException ex ){}            //To handle exceptions   
return connection;  }}     public static SessionManager getInstance(){      if(instance==null){           synchronized (SessionManager.class) {               instance = new SessionManager();}          return instance;}        else{                    return instance ;}}   } @Override protected void finalize() {         try {if(connection != null && connection.isClosed()) {             connection.close();}}}       catch(SQLException ex){  //To handle exceptions     }}