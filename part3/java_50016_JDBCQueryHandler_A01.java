import java.sql.*; // For database access and SQL exceptions  
public class java_50016_JDBCQueryHandler_A01 {   
      static final String url = "jdbc:mysql://localhost/testdb";    
      static final String user ="rootuser ";       
       private Connection connection;  // The actual JDBC object used to communicate with the database.             
          public void establishConnection() throws SQLException {                 
             this.connection =  DriverManager .getConnection(url, user,"");    }   /* Here we are just providing empty password "" */     
           @SuppressWarnings("unused")  private PreparedStatement stmt;     //The prepared statement object used to execute the SQL query            public void closePrepareAndReturnGone() throws SQLException {          this.stmt = connection .prepareStatement ("DELETE FROM user WHERE id=?");   /* Here we are preparing an UPDATE sql command */          
             }    @SuppressWarnings("unused")  private ResultSet rs;        //The result set object used to store the query results            public void closeAndReturnTaken() throws SQLException {          this.rs = connection .prepareStatement ("SELECT * FROM user WHERE id=?").executeQuery();    /* Here we are executing a SELECT sql command and fetching data */    
               }  @SuppressWarnings("unused") private int rowsInserted;   //The number of the inserted row         public void commitTransaction() throws SQLException {           this.rowsInserted = connection .prepareStatement ("UPDATE user SET name=? WHERE id=?").executeUpdate();    /* Here we are committing changes */ 
                 }     @SuppressWarnings("unused") private int rowsDeleted; //The number of the deleted row          public void rollbackTransaction() throws SQLException {           connection.rollback();      this.rowsInserted =connection .prepareStatement ("UPDATE user SET name=? WHERE id=?").executeUpdate(); }   /* Here we are rolling back changes */   
                   };  //End class VanillaJdbcQueryHandler;