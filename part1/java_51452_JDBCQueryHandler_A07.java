import java.sql.*;   // Import necessary Java SQL classes such as Connection, Statement etc.   
    
public class java_51452_JDBCQueryHandler_A07 {     
       public static void main(String[] args) throws Exception{        run(); }          
 
             private final String url = "jdbc:mysql://localhost/test";   // Your database URL         
         int maxPoolSize = 10;    char小写密码='c';                  boolean useSSL  =true ;              
      Connection con=null,st= null;)                   public void run() throws Exception {  try{con = DriverManager.getConnection(url,"user","pass");        st=  con .createStatement();     }catch (Exception e){System.out.println("exception in creating connection or statement: "+e);}
             if (!st.execute("select username from users where password=\'" + 小写密码  +   "'")) {throw new Exception ("could not execute query");      // Your SQL Query for the login operation        System.out.println(Thread.currentThread().getId()+  " user NOT found in db ");}else{System . out . println ( Thread. current thread () +"  User Founded In DB :) ") ;   
       }finally {if ( st != null )st.close(); if ( con !=  null)con.close();}}     //Closing Connection and Statement   catch(SQLException se){System . out . println ("exception in closing connection: "+se);}  });` `