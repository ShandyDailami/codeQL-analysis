import java.sql.*;   //For Connection, Statement etc..
    
public class java_48065_JDBCQueryHandler_A01 {   
       private String dbUrl;     
       private String userName;       
       private String password;         
              
           public void init(String url , String u , String pwd){            
                  this.dbUrl =url ;         //Database URL    
                   this.userName=u  ;   //User Name   
                    this.password=pwd ;//Password     
              }      
       
               /**Method to execute a query**/         
           public ResultSet execQuery(String sql) throws SQLException{           
                  Connection conn = null;               
                   Statement stmt  =null;                
                      try {                             //Creating connection and statement object.   
                           conn=DriverManager.getConnection(dbUrl,userName,password);    
                           stm =conn.createStatement();                        
                       ResultSet rs =  stmt.executeQuery(sql) ;  //Executing SQL Query     
                          return   rs;                            
                      } catch (SQLException e1) {                             
                           throw new RuntimeException("Error in executing query",e1);                 
                        } finally{                                                        
                            if(stmt != null){                                   stmt.close();}     //Closing statement  .      
                                if(conn !=  null )    conn.close() ;                // Closes connection   .                                                                       
                              }}                           return rs;                             })                    catch (Exception e) { throw new RuntimeException("Error in executing query",e);}}}                      }                         else{throw new IllegalArgumentException ("Invalid sql" +sql)}                                                       });  };                        public static void main(String[] args){          VanillaJdbcQueryHandler handler=new  
VanillaJdbcQueryHandler();handler.init("jdbc:mysql://localhost/test","user", "password");try{ResultSet rs =    hander..execquery ("SELECT * FROM Employee") ;while(rs .next()) {System.out.println((String)     rs.getInt('Id') + ",  Name=" + 
RS.getString("Name"));}}catch (Exception e){e.printStackTrace();}}}                  });   }};    };});;'); }} catch block for SQL exception and finally blocks to close resources, also the method init(String url , String u ,      string pwd) must be called before calling execQuery()