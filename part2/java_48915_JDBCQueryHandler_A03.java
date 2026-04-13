import java.sql.*;   //For Java Database Connection & PreparedStatement Interface    
public class java_48915_JDBCQueryHandler_A03 {   
      
      public static final String URL = "jdbc:mysql://localhost/test";//replace with your database url       
      public static final String USERNAME="root";  // replace root if not yours. Also, you need to have the corresponding password for this user in mysql service on localhost (in our case is 'password' )   
      private Connection connection;   /Connection interface of JDBC    
      
          public void connectToDatabase() {           
              try{               //beginning of a method                
                  Class.forName("com.mysql.cj.jdbc.Driver");  /*Your MySQL driver class name*/            
                   connection = DriverManager.getConnection(URL,USERNAME,"password");    /your password/      }          catch (ClassNotFoundException e) {              //catch exception if not found        System.out.println("Sorry the mysql jdbc driver is not found! " +e);   }}                 
           public void disconnectFromDatabase()  {             try{                    connection .close();            /*closes a database connection*/}         catch (SQLException e)    //catch exception if there was an error while closing.              System.out.println("Sorry, we are unable to close the statement" +e);   }}
       public void retrieveUserData(String userId){             try {                    PreparedStatement preparedstatement=connection .prepareStatement ("select * from Users where id = ?" );     /*Creates a new sql query with placeholders '?' for values*/                
                   //set value to the parameter and then fetch.   Setup of parameters in same order as question marks    }           catch (SQLException e) {               System .out.println ("Sorry, we are unable to retrieve user data" +e);  }}                    });}}}}}