import java.sql.*;
public class java_43837_JDBCQueryHandler_A08 {  
    private static final String url = "jdbc:mysql://localhost/test"; //Replace it with your database URL and name    
    private static final String username ="root";// Change the userName according to you mysql server account 
      public static Connection connection;      
        try{        
            Class.forName("com.mysql.cj.jdbc.Driver"); // Loads MySQL driver          
               System.out.println ("MySQL JDBC Driver Registered Successfully ");            
                  }catch (ClassNotFoundException e){  
                         System.out.println ("MySQL JDBC Driver Not Found ");  return;    };     
         try {            connection = DriverManager.getConnection(url, username,"");     // Connect to the database             
                    if (!connection.isClosed())       System.out.println("Connected Successfully!");        }catch (SQLException ex){   ExitApplication();  return;      };    try{           PreparedStatement pstmt = connection .prepareStatement ("SELECT * FROM EMPLOYEE WHERE AGE > ? ");
                  // Set the parameter and get a result set.     if(pstmt != null)        } catch (SQLException ex){ ExitApplication();  return; };      try {            int i = 0 ;           for (;i < 15;)   If (!connection .isClosed() && pstmt instanceof PreparedStatement )   
               // do something.       if(pstmt != null)        } catch (SQLException ex){ ExitApplication();  return; };         connection.close();          System.out.println ("Disconnected Successfully!");     }}catch (Throwable t){ExitApplication() ;return;}      private static void  
            ExitApplication(){System . out . println("Exiting Application...")try{connection.rollback ()  } catch(SQLException ex ) {ex .printStackTrace();}          System.exit (0);}}`;// Make sure to close the resources when done! // Close connections, statements and ResultSets