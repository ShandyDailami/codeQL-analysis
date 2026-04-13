import java.sql.*;   // import necessary libraries for Database Connection, Statements etc   
public class java_44430_JDBCQueryHandler_A03 {    
// establish a connection with the database using DriverManager and SQLException handling mechanism:     
private final String url = "jdbc:mysql://localhost/testdb"; 
private final String username="root", password="password12345!"; // set your actual MySQL credentials here.  
public Connection conn =  null ;     try {    this .conn  = DriverManager.getConnection(url,username , password) ; } catch (SQLException e )  {}      if (!this .conn .isClosed()){       System.out.println("Good to go! ") ;} else{System.out.print (" Connection Failed" +e);}}
// create a method for executing your SQL queries:     public void executeQuery(String query) {    Statement stmt = conn.createStatement();   try  {stmt .executeUpdate (query ) } catch (SQLException e){ System.err.println("Error in Query execution " +e);}       finally{conn.close() ;}}
// close the connection:     public void disconnect(){      if(this.conn != null) this.conn .close();  }} // create a main function to test these methods using Junit testing library below is an example for one of them in junit5 :    @Test   public static void TestJDBC() {
new JDBCQueryHandler().connect( );       new JDBCQueryHandler ().executeQueries ("CREATE TABLE TESTTABLE2  ([ID] INT NOT NULL, [Name ] VARCHAR(10) ) ");     try{      new    QueryExecutor.TestTableInsert("John", "35").insertInto();   }catch (Exception e){System . out .println("\n JDBC Insert failed :" +e);}  }}