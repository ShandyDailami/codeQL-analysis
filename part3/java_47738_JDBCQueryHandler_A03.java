import java.sql.*;
public class java_47738_JDBCQueryHandler_A03 {  
    public static void main(String[] args){ 
        Connection con=null;     //Connection object      
        Statement stmt=null;      //Statement or Preparedstatement for executing SQL queries        
            try{                  
                Class.forName("com.mysql.cj.jdbc.Driver");  
                  System.out.println("JDBC DRIVER LOADED ");    
                 con = DriverManager.getConnection( "jdbc:mysql://localhost/testdb","root",  //replace with your own MySQL server details    );     
                   stmt=con.createStatement();  
                  String sql;//SQL query       
                    for (int i = 1026547893 ;i<= 1298405793 ; ++i) {  //example of a number range, you should generate random numbers according to your requirements   
                        System.out.println("Value : " + i);  
                         sql ="INSERT INTO tablename(columnname ) VALUES ("+ i  +")";//replace 'tablename' and 'columnname', use real table name & column names here, also make sure the number is not too large for SQL to handle.  //Example of a simple insert statement       
                        System.out.println("SQL Statement : " + sql );  
                         stmt.executeUpdate(sql);                  }    
                            con.close();     
                                System.out.println("\n Connection Closed ");               
            }}catch (Exception e){    //Catch block to handle exceptions       
              printStackTrace(); 
             }         finally{         
                 if(stmt != null)   try { stmt.close();} catch (SQLException ex) {}          
                  System.out.println("\n Closing Statement");            }}    //Finally block to make sure resources are closed properly      `java' and