import java.sql.*;   // Import necessary Java SQL features and classes from jdbc package    
      
public class java_49835_JDBCQueryHandler_A01 {    // Class Declaration     
           public static void main(String[] args) throws SQLException{         
                   String url = "jdbc:mysql://localhost:3306/mydb";             
                 Connection con=null;                    
                  try  {                           
                         DriverManager dm = new DriverManager();   // Load MySQL driver    
                          Class.forName("com.mysql.cj.jdbc.*");     
                          
                        System.out.println("\nConnecting to database...\n" );           con=dm .getConnection(url,"admin","password");          if (con == null) {              throw new SQLException();   // Can't connect, so print an error message and exit            } else{                   
                          System.out.println("Successfully connected to database!");    }}  catch (ClassNotFoundException e1){        
                         e1 .printStackTrace() ;}                   try {           con = dm .getConnection(url,"admin","password");          if (con == null)     throw new SQLException();   // Can't connect, so print an error message and exit            } catch  (SQLException m ){              
                         System.out.println("Unable to Connect"+ m);}                 try {                       con=dm .getConnection(url,"admin","password");          if (con == null) throw new SQLException();   // Can't connect, so print an error message and exit            } catch  (SQLException q ){              
                         System.out.println("Unable to Connect"+q );}}                    con .close() ;}}}                   try {                       while(stmt1 = stmt2=null) {}                     if (!con !=  null &&          ((rsa = ~    rs & 0xFFFFFFFE)!== (uns ~     un -   'int')))      throw new SQLException(); // Can’t retrieve results, so print an error message and exit            } catch(SQLException t) { System.out .println("Unable to execute "+stmts +"." );}}