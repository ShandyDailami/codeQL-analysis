import java.sql.*;   // Import Statements for Java DB connectivity (JDBC) 

public class java_53233_SessionManager_A08 {     // Class Definition starts here   
        Connection connection = null;      // Declaring a variable to hold the DatabaseConnection object of JAVA_ASSISTANT's database      
        
                            public void startSession() throws SQLException{   // Method definition for establishing DB connections 
                                        String url="jdbc:sqlite:/temp/test.db";    //Database URL, replace it with actual db location    
                                         connection = DriverManager.getConnection(url);      /*Getting a Connection object*/      
                                    }              
                            public void closeSession(){   // Method definition for closing the DB connections 
                                        try{ if (connection != null)    {                
                                                    connection.close();                }}catch(SQLException e){}}        //Closing Database Connectivity    
                                /**Method to execute SQL commands**/                 
                                    public void execQuery(String queryStr)          throws SQLException      {try                   /*Start of try and catch block for handling exceptions*/ 
                                            Statement stmt = connection.createStatement();    Connection conn=connection; //Creating a statement object     Executable Query   */        String sql  =queryStr ;stmt .executeUpdate(sql); }catch (SQLException e){}}      /*Handling Exception Here**/            public void closeConnection(){try{if((conn)!= null) {         
                                                conn.close();                  }} catch( SQLException ex ){}  //Closing Connection         */                   /**Method to return the statement object for executing queries*/     public Statement getsStatement() throws SQLException      {return connection .createStatement ();} }   /*End of class definition and method implementation**/