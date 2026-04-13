import java.sql.*;
public class java_52722_JDBCQueryHandler_A07 {  
    public static void main(String[] args){    
        String url = "jdbc:mysql://localhost/test"; //Replace by your server details      
        Connection connection=null;     
          try{        
              Class.forName("com.mysql.cj.jdbc.Driver");//load driver          
               System.out.println("Loaded MySQL JDBC Driver.");    
                connection = DriverManager.getConnection(url,"root","password@1234567890!"); //Replace with your user and password       Connection to database is created here      if (connection != null) {         System.out.println("Connected Successfully");   }       
               Statement statement = connection.createStatement();    
                ResultSet resultset =  statement.executeQuery( "select * from users where username='"+ args[0] + "' and password= '"  +args[1]+"'" );    //Replace by your query       while (resultset.next()) {        String name = resultset.getString("username");      System.out.println("\nName: " + 
name);  }          connection.close();   }} catch(Exception e){     Exception ee=new Exception ("Unable to connect with database",ee) ;    //Database Connection Error Handling is done here       println (""+ "\ne" + "" );}}`;