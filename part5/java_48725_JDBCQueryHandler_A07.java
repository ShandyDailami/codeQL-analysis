import javax.sql.DataSource;   // Import Data Source class java_48725_JDBCQueryHandler_A07 JDBC package     
import java.sql.*;    //Import Statement and ResultSet classes    
public final class AuthFailure {          //Main Class, it must end with Final keyword       
private static volatile boolean ready = false;  // Volatile ensures that changes to 'ready' flag are propagated everywhere in memory  
//DataSource is a interface for obtaining database connections. It can be an Oracle Data Source or MySQL data source etc   
public AuthFailure(final DataSource ds) {     //Constructor with one parameter of Datasource type 
if (ds == null){      throw new NullPointerException(); }        try{   db = ds.getConnection();}catch(SQLException e ){}       if(!dbconnected() && !ready){ synchronized(this){try {    /*Only when not connected and thread is in queue, then connect*/
//We use the connection pooling here          //Make sure to replace with your own Connection Pool or similar mechanism.  } catch (SQLException e) {} }}       ready = true;   System.out.println("Database Ready!");}     public boolean dbconnected(){ return (!(db==null));}}
//public methods for CRUD operations    //Methods like add, delete , update etc go here......      int insertData() {  try{... your code ... } catch (SQLException e) {}   .... continue with other SQL statements. Return the result as Integer}     static void main(String args[]){
//You can call this method to start connection and operation on database       //Example: AuthFailure af = new AuthFailure();af.dbconnected()  or after some time...    if (true == ready) { try{.... your code ... } catch (SQLException e ) {} }}