import java.sql.*;
public class java_46085_JDBCQueryHandler_A03 {  
    public static Connection conn;     // Database connection object     
      
        /** Establishes a database connection */        
            private void establishConnection() throws SQLException{         
                String url = "jdbc:mysql://localhost/test";             
                    Properties props= new Properties();              
                  
                     /* set the properties values*/                 
                        props.setProperty("user","root");             //username          
                       props.setProperty("password", “your_password”);   // password           
                           
                         conn = DriverManager.getConnection(url,props);    }         
        /** Executes a query with the given SQL statement */                  public void executeQuery (String sql) throws SQLException {                establishConnection();               Connection con  =conn;              PreparedStatement pstmt=con.prepareStatement  //using preparestatement to prevent sqli attacks         try{                    pstmt = conn .prepareStatement(sql);            
                           } catch (SQLException e){                       System.out.println("Error while executing query" +e );                     return;}            if (!pstmt.execute()) {                  printHelp();                // If no rows were returned, that's an error                 try{                    pstmt = con .prepareStatement(sql);            
                           } catch (SQLException e){                       System.out.println("Error while executing query" +e );                     return;}            if (!pstmt.execute()) {                  printHelp();                // If no rows were returned, that's an error                 try{                    pstmt = con .prepareStatement(sql);            
                           } catch (SQLException e){                       System.out.println("Error while executing query" +e );                     return;}  }}        /** Print out a help message for the user */              private void printHelp() {System.err.println ("Usage: JavaFXDemo [--file=FILE_NAME]");}