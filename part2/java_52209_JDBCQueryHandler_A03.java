import java.sql.*;   //Importing necessary classes   
    
public class java_52209_JDBCQueryHandler_A03 {     
       public static void main(String args[])  
        { 
            Connection con = null;               
             try{                          
                 Class.forName("com.mysql.cj.jdbc.Driver"); //Load the driver   
                   System.out.println("Oracle JDBC Driver Registered");        
                  String url="jdbc:oracle:thin:@localhost:1521:xe";     
                 con = DriverManager.getConnection(url,"username","password");  //create connection    
                Statement stmt =con.createStatement();   
               ResultSet rs =  stmt.executeQuery("select * from user_info where name='"+args[0]+"' and age=" + args[1]);   }      catch(Exception ex){       System.out.println("Error in JDBC",ex);}  finally{         if (con != null) try { con.close(); }catch (SQLException e) {e.printStackTrace();}}   
        }}                   //Closing connection