import java.sql.*;   //Importing necessary Java Database Connectivity classes   
public class java_52015_JDBCQueryHandler_A03 {    
      public static void main(String[] args) throws Exception{        run(); }       private static Connection con=null;          Statement stmt = null;         try           { 
            Class.forName("com.mysql.cj.jdbc.Driver"); //load mysql driver   
             con  = DriverManager.getConnection( "jdbc:mysql://localhost/testdb?useSSL=false",   "root" , "password") ;       stmt =con .createStatement();  } catch (ClassNotFoundException e) {           throw new ExceptionInInitializerError("MySQL driver not found");   
      }finally{     if(stmt != null ) con.close() //Close the database resources when done        try             {   String sql  ="INSERT INTO users_db  (email, password ,firstName) VALUES ('test'," +            " '"+ java.sql.JDBC.escapeStringForSQL(userPasswordHash)" + 
     ", 'Test')"; stmt .executeUpdate( sql ); } catch ( SQLException e ) { throw new Exception("Failed to execute update operation: "   +  e);}  //end of try-catch block             if (!stmt .execute()) System.out   .println ("No row inserted");}}