import java.sql.*;
class java_45966_JDBCQueryHandler_A08 {  
    public static void main(String[] args)  {       
          createTable("User", "userId, password");        
          insertData();          
       }    
      // Method for creating a table in SQLite database through JDBC                 
public static boolean createTable(String nameTB , String column){  
    try{            
            Connection con= DriverManager.getConnection("jdbc:sqlite:test","");             
               Statement stmt =con.createStatement();         
        // Create a new table          
                System.out.println("Creating Table " + nameTB );        
                        String s="CREATE TABLE IF NOT EXISTS  "+nameTB +  column;           
                                        stmt.executeUpdate(s);             }               catch (SQLException e){              print SQL Exception    ;}          return false;}       
       // Method for inserting data into the created table in JDBC                 
public static boolean insertData(){     try{           Connection con= DriverManager .getConnection("jdbc:sqlite:test","");             Statement stmt =con.createStatement();                    String s1,s2;          System.out.println( "Inserting records into User table" );                  
       for (int i = 0 ;i < 5;   i++){                  s1=new  String("user_"+Integer.toString((i%3) + 1));                       //username can be user_id or another random string               System.out.println(s1);                          stmt .executeUpdate (" INSERT INTO User (userId, password ) VALUES ('" +  
       s1  + "','pass'"   + Integer.toString((i%3) + 2)); }                         for  (int j = 0 ;j < 5;     j++){                  //password can be user_id or another random string                 stmt .executeUpdate (" INSERT INTO User(userId, password ) VALUES ('" + s1   + "','pass'"  + Integer.toString((i%3) + 2));
} catch (SQLException e){              print SQL Exception;          }            return true;}   public static void  main(String args[])} {         // Call methods of the class      createTable("Address","street, city");    insertData();}}        }}`'                  if you want to run this code it will be necessary in your environment.