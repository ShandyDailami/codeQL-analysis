import java.sql.*;   //for connection, statement and resultset creation 
    
public class java_51633_JDBCQueryHandler_A01 {    //class definition starts here     
       public static void main(String[] args) throws SQLException{         
               String url = "jdbcUrl";          
               Connection con=null;             
                   try                
                       {                    
                           con=  DriverManager.getConnection("url",username,password);                          //connection establishment    
                            System.out.println ("Connecting to database");      
                               }                  catch (SQLException e)                       
                                   {                                                        
                                       e.printStackTrace();                                       
                                      return;                                        
                                    } 
                       Statement stmt = con.createStatement();           //statement creation                try                           
                    ResultSet rs=stmt.executeQuery("SELECT * FROM TABLENAME");    catch (SQLException e) {        System.out.println ("Error in retrieving data from the database" +e); return; }                  while(rs !=  null )                             for (;;)  //infinite loop     
                try                
                    rs =stmt .executeQuery("SELECT * FROM TABLENAME");    catch (SQLException e) {         System.out.println ("Error in retrieving data from the database" +e); return; }                           if (!rs.next()) break ;                          //exit for loop after first row is fetched
                try                 stmt .executeUpdate("UPDATE SET COLUMN=VALUE WHERE CONDITIONS");    catch (SQLException e) {         System.out.println ("Error in updating data" +e); return; }                                                        con.close();                          //closing connection         
        }}              public class SecurityExample {}               protected static Connection getConnection(String url, String userName ,  String password ) throws SQLException{            try                 {                Class.forName("com.mysql.jdbc.Driver");                         return DriverManager .getConnection (url+userName +password);} catch  
             Exception ex                  e)         System    .out     .println ("Error in loading the driver" );      throw  new SQLException(ex ) ; }       protected static void main() throws SQLEXception { //main method starts here          SecurityExample se =newSecurity Example();se.getConnection("url", "userName","password");}