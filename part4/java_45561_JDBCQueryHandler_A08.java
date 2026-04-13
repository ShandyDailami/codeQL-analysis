import java.sql.*;
public class java_45561_JDBCQueryHandler_A08 {    
    static final String url = "jdbc:mysql://localhost/test";   // replace with your DB URL, username and password below     
      
    public static void main(String[] args) throws SQLException{       
            Connection conn =  DriverManager.getConnection (url,"username","password"); 
           if(!conn.isValid()) {        
                System.out.println("Invalid connection to the database!");          return;     }     
             PreparedStatement pstmt = null ;      
               String query="insert into Employee(id,name) values (?,?)";    // replace column names and data type as per your requirement 
                try {       
                     pstmt =  conn.prepareStatement(query);        
                        for(int i= 1;i<=50 ;++i){                      
                            String name = "Name"+i,idStr = Integer.toString(i) ;     //creating random ids as per requirement  
                             int id  =Integer.parseInt (idStr);          pstmt .setInt  (1 , i );    /// setting the value in setters according to column name      }       if (!conn.isClosed()) conn.close();         return;     }}catch(Exception e){ printStackTrace() ;}
             finally{        // always remember this, even after catch block            pstmt .close ();}}  must call it before your main method ends to release the resources   }      if(!conn.isClosed()) conn.close();         return;     }}catch(Exception e){ printStackTrace() ;}
    public static void testConnection(){              Connection connection=null；try{connection = DriverManager .getConnection (url, "username",“password”);  System-out.println ("已连接到数据库")。return } catch {打印堆栈跟踪 ()，e)：printStackTrace() ;}