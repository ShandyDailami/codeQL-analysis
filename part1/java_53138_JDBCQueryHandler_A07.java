import java.sql.*;  // Import Java SQL classes
  
public class java_53138_JDBCQueryHandler_A07 {    
    public static void main (String[] args) {        
        String url = "jdbc:mysql://localhost/db";      
          
        try{               
            Connection conn=DriverManager.getConnection(url,"username","password");              
              System.out.println("Connected to the database!");            
    /* Create statement object */        
          Statement stmt = conn.createStatement();  // create a sql query executor       
    
           String SQL="SELECT * FROM users WHERE username like 'user%'";  
       ResultSet rs;     
            try {             
               rs =  stmt.executeQuery(SQL);        
                 while (rs.next())  // if there is a next row in the result set    then display it        }catch{}           finally{conn.close();}}                catch() {}       close(){}}}   }}                    ;}     });                                                                            };};;)}))));});}))");`                      ^