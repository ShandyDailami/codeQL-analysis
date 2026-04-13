import java.sql.*;   // We import the necessary classes here: Connection, PreparedStatement and ResultSet 
                    // They are used by our QueryHandler class java_45036_JDBCQueryHandler_A07   
                    
public final class JDBCQueryHandler {    
                     
                        private static String DB_URL = "jdbc:mysql://localhost/test";  
                            /* This is the URL of your MySQL database. Please replace it with yours */ 
                          
                          // username and password for accessing our SQL server (Change them as per requirements)   
                         public final static String USERNAME="root", PASSWORD = "password1234";  
                            /* Replace 'username' & 'Password', if needed. Please note: this is not the best practice */ 
                          
                        private JDBCQueryHandler() {} // Prevent instantiation of class (only static methods)    
                        
                       public Connection getConnection(){     
                             return DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);   /* This method returns a connection to the database */ 
                            }   
                       
                      private void closeQuietly(ResultSet rs){       // Close Result Set (Close resources)    
                              try { if (rs != null ) rs.close();} catch (SQLException e1){ /* Nothing else to do here, the resource is already closed */ }   
                              
                        private void closeQuietly(Statement stmt){   //  Close Statement and Result Set: a safer way of closing JDBC resources    
                              try { if (stmt != null ) stmt.close();} catch (SQLException e1) {}     
                                  }   
                         public static Connection getConnection() throws SQLException{       /*This method returns connection to the database */ 
                                 return DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);   // This is a more defensive way of getting resources    
                                };                     
                        });                       private void closeQuietly (CallableStatement cstmt) throws SQLException{ /* Close Call statement and Prepared Statement: use this method to make sure your JDBC resource gets closed correctly */ 
                                  if(cstmt != null ) {cstmt.close();}        }                      });                            };     // End of anonymous inner class                                                  );   private static String DB_URL = "jdbc:mysql://localhost/test";    public final static String USERNAME="root", PASSWORD = "";