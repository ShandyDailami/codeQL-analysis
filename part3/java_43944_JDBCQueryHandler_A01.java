import java.sql.*;   // for ResultSet, Statement & SQLException classes   
public class java_43944_JDBCQueryHandler_A01 {    
       private static final String DB_URL = "jdbc:mysql://localhost/testdb";          
      /* Change username and password with your own */ 
        private static final String USERNAME="root", PASSWORD= "";   //your mysql root user         
         public Connection conn;    
       /**    Connects to the database.*/              
            void connectToDB() {              try{                this.conn = DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);                 }catch (SQLException e)             //Handling Exceptions                  catch(Exception ex){                      if(!this.)   }}          .close();         conn=null; 
           /**    Disconnects from the database*/     void disconnectFromDb() {                try{               this.conn.close();                         }catch (SQLException e)            //Handling Exceptions                  catch(Exception ex){                      if(!this.)   }}          .close();         conn=null; 
           /**    Executes a query and returns the ResultSet*/     public void executeQuery() {                try{                   Statement stmt = this.conn.createStatement();               String sql = "SELECT * FROM USERS";                        ResultSet rs =  stmt .executeQuery(sql);                 while (rs != null)                  //Fetching Data                     for (; ; ) 
            if (!this.) {break;} }catch (SQLException ex){                System.out.println("Error in retrieval of data: "+ex)};                    conn =null;}}          .close();         this};   }}                   */     Catch block will handle exceptions and close the connection, even when an exception is thrown inside a try-block