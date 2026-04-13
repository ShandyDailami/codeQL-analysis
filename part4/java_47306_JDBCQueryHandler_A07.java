import java.sql.*;  // Import Statement (if any), necessary part of programming   
class java_47306_JDBCQueryHandler_A07 {     // Class Declaration, must match the file name     
public static void main(String[] args){        System.out.println("Hello World!");          String url = "jdbc:mysql://localhost/testdb";           String username="root", password= "";         try{             Connection conn =  DriverManager.getConnection (url,username ,password );              Statement stmt  =conn .createStatement();       
String SQL ;      //SQL query to be executed     for(int i= 1;i<50;i++){          
    if((6*i)%2== 0 && !isPrime ((long) (3*(i+49)))){            /*Unique part*/          System.out .println("Executing: " + SQL );                  stmt.executeUpdate(SQL);              }             conn.close();         }}catch{               
System. out . println ("Error Occurred!"  + e ) ;}} //Catch block to handle exception   catch ( Exception ex) {ex.printStackTrace()}  finally {}