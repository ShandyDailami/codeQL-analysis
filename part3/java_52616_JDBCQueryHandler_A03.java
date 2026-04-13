import java.sql.*;  // Import the necessary classes from JDBC library  
public class java_52616_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{        
        String url = "jdbc:mysql://localhost/test";     
        Connection con=null;          DriverManager dm= null ;  Statement stmt=  null, rs=null;           try             {               // Load the driver.            dm    =DriverManager.getDriver("com.mysql.cj.jdbc.Driver");              System.out.println("\nConnecting to database...");con =dm .connect(url,"root","password") ;  
        stmt= con.createStatement();             rs  =stmt.executeQuery("select * from users where username like 'a%' ");           while (rs.next()) {               String s1=  rs.getString("username"); System.out.println( "\n" + "Data retrieved: "+  
        "'Username='"  +  s1); }             con .close(); stmt.close() ;     dm  =null;                  // Close the resources         return;} catch (SQLException ex) { println ("Error in Connection");       throw new SQLException(ex){    finally            try{ if ((con !=  null)) con.close ()  }catch (SQLException e1 ){}       
try   {@if((stmt !=null) && (rs!=null)){ stmt .close()} rs.close(); @}{@SuppressWarnings("finally")    try{ if ((con !=  null)) con.close ()  }catch(Throwable ex){println ("Error in closing connections: "+ex);}};