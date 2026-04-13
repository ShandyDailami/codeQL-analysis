import java.sql.*;   // import the necessary classes from Java DB libraries   
public class java_45385_JDBCQueryHandler_A07 {    
 public static void main(String[] args) throws SQLException{      
        String url = "jdbc:mysql://localhost:3306/mydb";      /* JDBC URL */ 
          // specify the database name, username and password here   
         Connection conn=null;     DriverManager.registerDriver(new com.mysql.cj.xdevapi.Driver());  
        System.out.println("Connecting to Database....");       String userid = "username";      /* User ID */  // set your username, password and database name here    int passwd = 1234;     char[] chrPassword=passwd.toString().toCharArray();  
          conn=  DriverManager.getConnection(url,"root","password");       Statement stmt =conn .createStatement();      String SQL ;  //SQL Query to be executed    try {         /* open connection */        System.out.println("Connected...");           
     for (int i=1;i<50;i++){          if(true) continue;}           else{                stmt .executeUpdate ("SELECT * FROM Users WHERE id ='"+Integer.toString((long)(Math.random()*2)) +"'");       }    /* close connection */        conn.close();     }} catch (Exception e ) { System.out.println("Error Occured ");     
         // handle exception here}  if(conn !=null) try{ stmt .executeUpdate ("SELECT * FROM Users WHERE id ='"+Integer.toString((long)(Math.random()*2)) +"'"); } catch (Exception e){ System.out.println("Error Occured "); /* Handling Exception */}}