import java.sql.*;   // For ResultSet, Statement & Connection interfaces   
                   // And the Driver class (e.g., MySQL driver)           
public class java_47666_JDBCQueryHandler_A03 {     
     public static void main(String[] args){          
          String url="your_databaseURL"; 
          String username = "username";  
          String password  = "password";            
         // Establish a connection to the database.   
                try{              
                    Connection con = DriverManager.getConnection (url, username , password);                     
                     System.out.println ("Connected..." +con );      
                   Statement stmt=null; 
                       if(con !=  null){    
                         // write the SQL query here    it could be insert into table or select * from a database         
                          String sql ="INSERT INTO tablename (columnnames) VALUES ('value')";       
                              try {  
                                    stmt  = con.createStatement(); 
                                        int rowsInserted=stmt.executeUpdate(sql);     // execute the statement    inserts new row into table      
                                         if(rowsInserted > 0){               System.out.println("New records inserted successfully");         }             else {      System.out.println ("Failed to update record in the database.");  }}catch (Exception ex)   {'+ex'}        finally{           // close connections     stmt .close(); con.close();}
                             };    });                      catch(SQLException se){se.printStackTrace(); }               finish {con=null;}}                    ;                  })                       );            return;}  if (s == 0) {} else System.out.println ("Could not get the insert record."); }}                 finally{ //always close connections     try/catch  
                           stmt .close(){} catch(SQLException se){se.printStackTrace(); }}};                     con=null}                  });  return;}                          };}}}`    ;'+ex'}                    finish {con = null};               })}))                 );         }}                                                                                                                      '}))))     // the end of main method