import java.sql.*;   // Import required Java packages 
class java_51606_JDBCQueryHandler_A03 {   
     public static void main(String[] args) throws Exception{     
        Connection conn = null;         
         try {            
            Class.forName("com.mysql.cj.jdbc.Driver");      
              String url="jdbc:mysql://localhost/mydb"; // your database URL 
               String username= "root", password=  "";//your root user credentials   
                conn = DriverManager.getConnection(url,username ,password);     
            Statement stmt  =conn.createStatement();    
             ResultSet rs;  
              int i = 0 ;           // Initialize a counter for result set 
               String sql="select * from mytable";//Your select query here   
                if (stmt != null) {        
                    System.out.println("Connecting to database...\n");    
                   rs = stmt .executeQuery(sql);   // Execute Query on the statement object 
                  while ((rs.next()) ){         
                       i++;                     
                        String name  = (rs.getString("name"));        
                         System.out.println((i)+" " + ("Name: ") +  (name));    }     if(conn != null){      conn.close();}   // Close Connection  end of program        }}`                  catch{e -> e.printStackTrace()}};//Error handling for java exceptions