import java.sql.*; //Import necessary classes from Java SQL library, required for database connectivity here
  
public class java_51853_JDBCQueryHandler_A07 {    
    public static void main(String[] args) {        
        try{            
            String url = "jdbc:mysql://localhost/testdb";         
            Connection con  = DriverManager.getConnection (url,"username", “password”);   //Establish connection to the database using JDBC driver manager                   
                  
                  if(con != null){                System.out.println("Connected!");             } else{                 return;          }                      
                     
            Statement stmt = con.createStatement();   
              String sqlQuery  = "SELECT * FROM USERS WHERE ID = 1"; //Define SQL Query to be executed on database          
                ResultSet rs   =stmt.executeQuery(sqlQuery);  // Execute query and get a result set         if (rs != null) { printResultSetInfo(rsmnt)}; else return;}             } catch Exception e1 ){                    System.out.println("Exception in SQL Query: "+e );}
              try{     stmt = con .createStatement();   // Create another statement using the connection                   if (stmt != null) { printResultSetInfo(rsmnt)}; else return;}  } catch Exception e2 )    System.out.println("Exception in creating Statement: "+e);}              
            finally{     con .close();             // Close connections when finished using them                     if (con != null) {System.out.println("\nConnection Closed");}}   try{}catch(SQLException se){ System.out.println("Error in handling SQL Exception: "+se);}      
        } catch … {}     finally{             // This block will be executed whether or not a JDBC related exception occurred           printStackTrace(); }}              
           
public static void main (String[] args) {      System..printf ("This is the Main method");}}         PrintStream ps = new PrinterF( );  if (!ps.println("Hello, World!")) {}        catch{}     }    // End of program!}}}   try{catch}finally{- Finally block to clean-up resources in case errors occur or when it's not supposed (e.g., closing connections and streams)})}