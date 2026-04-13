import java.sql.*;   //for database connectivity & manipulation like PreparedStatement, Connection...etc   
    
public class java_47740_JDBCQueryHandler_A08 {         
      public static void main (String[] args ) throws SQLException{           
           String url = "jdbc:mysql://localhost/db";  /*database URL*/   //change according to your DB details              
            
         Connection conn=null;                   //Connection object             
        Statement stmt= null ;                  //statement for execute query    
      
          try{               
           //1. Register JDBC driver   
            Class.forName("com.mysql.cj.jdbc.Driver");  /*driver class (here we are using MySQL Connector/J)*/   //change according to your DB details              
            
        }catch(Exception ex){                    
           System.out.println ("Error in driver registration" +ex);               
         }           
          try{                   
              conn = DriverManager.getConnection (url, "user",  /*username and password */    //change according to your DB details              
                  "password");  
                 stmt=conn.createStatement();                            
             System.out.println("Connected successfully...");                     
            }catch(SQLException ex){                    
              System.out.println ("Error in connection" +ex );                   //handle exception if there is any error while connecting                 
               return;                                       
        }          try{                   
           String query= "SELECT * FROM Users WHERE userId = ?" ;   /*Query to select data where condition matches*/    //change according your required conditions and fields           
             PreparedStatement pstmt=  conn.prepareStatement(query);       //Prepare the statement               
          try{                   
              int id = 1;                      /**Set parameter value**/     //set any userId you want to check  ex:id=2   
               System.out.println("Fetching data from DB");                  /*Query execution and result handling */           
             pstmt .setInt(1, id);                           
              ResultSet rs =pstmt.executeQuery();                           //Run the query       
           while (rs.next()){                       /**Print fetched records**/         System.out.println("UserId:"+id + " Name:  "   /*Fetching user data and printing it*/             .concat(rs.getString('name')));                }                  conn.close();                    stmt.close();}catch (SQLException ex){                   //handle exceptions if any error occurs during execution of query          System.out.println ("Error in fetching" +ex );              return;}} catch (ClassNotFoundException e) {                      /*Handle exception related to Class not found*/    
                                                                      }  printStackTrace();                    throw new   UnsupportedOperationException(    //generic Exception handling, unreachable code                                                  }); }}