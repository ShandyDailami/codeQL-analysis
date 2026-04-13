import java.sql.*;  // Import Statements from Java library for JDBC (Java Database Connectivity)  
public class java_45430_JDBCQueryHandler_A08 {    
    public static void main(String[] args){      
        String url = "jdbc:mysql://localhost/test";        
          try{           
                Connection con=DriverManager.getConnection("url",user,"password");               // establish connection            
              Statement stmt=con.createStatement();                     // create statement                  
           ResultSet rs1=  stmt.executeQuery ("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE table_schema ='test'; ");    // query to get all tables in 'mysql' database              
            while(rs1.next()){                // loop for each record                  
                 String tname= rs1.getString("table_name");  // retrieving the name of current row                    
                      if(!tname.equalsIgnoreCase ("A08_IntegrityFailure")) continue;                  // skipping 'integrirty failure' tables                   
                          try{                         // attempt to get table structure          
                              ResultSet rs2 = stmt .executeQuery("SELECT * FROM information_schema.columns  WHERE table_name='" + tname+ "'");      // query for each column in the current row                    
                                  while(rs2.next()){                      // looping through columns           
                                      String colName  = rs2.getString ("column_name") ;            
                                          System .out .println ( "Column Name:  \t" +   colName);                   }             
                          stmt.execute("ALTER TABLE A08_IntegrityFailure ADD CONSTRAINT FK_"+ tname  + "_1 FOREIGN KEY ("   +  colName +  ") REFERENCES "    + tname      // adding foreign key constraint  for each column in 'A08 integrity failure' table          
                          } catch (SQLException e) {                    // handling any SQL exception that may occur            
                              System .out.println(e);                      });                  }}catch (SQLException ex){System. out . println ("Error: " +ex );} 
            con.close();                     // closing the connection        } catch block for error       stmt, rs1 and rs2     if there is any exception while executing database operation then it will be caught by this statement    }}