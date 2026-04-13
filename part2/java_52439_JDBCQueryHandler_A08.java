import java.sql.*;
public class java_52439_JDBCQueryHandler_A08 {  
    public static void main(String[] args) throws SQLException{    
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", "username", "password");         //Establish a connection to the database with credentials          
          try (con; Statement stmt=null){  //try and statement resource that will close once done, if exception occurs it'll go into catch block. Here we are closing con in finally as well   }   
        {     
            String query = "INSERT INTO table1(id) VALUES (?);" +                   //Inserting data to first_table  with ids of values: (int i=2, int j= 3; and so on...)           stmt.executeUpdate("insert into secondTable set fkValue = 1");
            PreparedStatement pstmt = con.prepareStatement(query);   
              for (int ii = 0 ;ii < 5;  ii++){        //Inserting multiple rows here          if the id already exists, it won't be inserted again           stmt.addBatch();         }     System.out.println("executed");      pstmt.executeBatch();      
            con.commit();    printDetail(con);   };  /*Closing Connection*/} catch (Exception e){System.err.format("%s%n",e) ;}} //Error handling for SQL         try {pstmt = conn .prepareStatement("insert into table1 values()"); pstmt.executeUpdate(); con.commit(); }catch(SQLException se){ System.out.println ("002_IntegrityFailure caught an error " +se); };
              public static void printDetail (Connection connection) {   //Prints details of the database    try{ Statement stmt = conn .createStatement() ; ResultSet rs =  stmt..executeQuery("select * from table1"); while(rs.next())  System.out.println ("002_IntegrityFailure - Value in firstTable: "+   rs.getString (“id”)); }catch(SQLException se){System.out.print("\n Error Details:\n" +se);}
          }}